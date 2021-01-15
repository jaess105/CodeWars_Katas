package Fundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Connect Four https://www.codewars.com/kata/56882731514ec3ec3d000009/train/java
 * Take a look at wiki description of Connect Four game:
 * <p>
 * Wiki Connect Four
 * <p>
 * The grid is 6 row by 7 columns, those being named from A to G.
 * <p>
 * You will receive a list of strings showing the order of the pieces which dropped in columns:
 * <p>
 * List<String> myList = new ArrayList<String>(Arrays.asList(
 * "A_Red",
 * "B_Yellow",
 * "A_Red",
 * "B_Yellow",
 * "A_Red",
 * "B_Yellow",
 * "G_Red",
 * "B_Yellow"
 * ));
 * The list may contain up to 42 moves and shows the order the players are playing.
 * <p>
 * The first player who connects four items of the same color is the winner.
 * <p>
 * You should return "Yellow", "Red" or "Draw" accordingly.
 */

public class ConnectFour {
    //6x7
    public static String whoIsWinner(List<String> piecesPositionList) {
        List<List<String>> spielfeld = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            spielfeld.add(new ArrayList<>());
        }
        String outcome = "Draw";
        List<String[]> list = piecesPositionList.stream()
                .map(s -> s.split("_"))
                .collect(Collectors.toList());
        for (String[] arr : list) {
            int alphabeticalPos = arr[0].charAt(0) - 65;
            String color = arr[1];
            spielfeld.get(alphabeticalPos).add(color);
            outcome = getWinner(spielfeld, alphabeticalPos);
            if (!outcome.equals("Draw")) {
                return outcome;
            }
        }
        return outcome;
    }

    //1 check if there are enough elements vertically or horizontally
    //2 if true check if the elements from the starting point on out are in the same color add one for each
    //3 if higher than 4 outcome = color of element
    // retrun "Red" or "Yellow" or "Draw"
    private static String getWinner(List<List<String>> spielfeld, int alphabeticalPos) {
        List<String> row = spielfeld.get(alphabeticalPos);
        if (fourInRow(row, alphabeticalPos)
                || fourInLine(spielfeld, alphabeticalPos)
                || fourVertically(spielfeld, alphabeticalPos)) {
            return row.get(row.size() - 1);
        }
        return "Draw";
    }

    private static boolean fourVertically(List<List<String>> spielfeld, int alphabeticalPos) {
        //von links unten nach rechts
        int hoehe = spielfeld.get(alphabeticalPos).size() - 1;
        int sameColorCount = 0;
        String colorOfOrigin = spielfeld.get(alphabeticalPos).get(hoehe);
        sameColorCount = fromLowerLeftToUpperRigth(spielfeld, alphabeticalPos, hoehe, sameColorCount, colorOfOrigin);
        sameColorCount = Integer.max(sameColorCount, fromUpperLeftToLowerRigth(spielfeld, alphabeticalPos, hoehe, sameColorCount, colorOfOrigin));
        return sameColorCount >= 3;
    }

    private static int fromUpperLeftToLowerRigth(List<List<String>> spielfeld, int alphabeticalPos, int hoehe, int sameColorCount, String colorOfOrigin) {
        Predicate<Integer> insideLowerBorders = (i) ->
                (hoehe + i >= 0 && alphabeticalPos - i >= 0
                        && spielfeld.get(alphabeticalPos - i).size() > hoehe + i);
        for (int i = 1; insideLowerBorders.test(i); i++) {
            if (colorOfOrigin.equals(spielfeld.get(alphabeticalPos - i).get(hoehe + i))) {
                sameColorCount++;
            } else {
                break;
            }
        }
        for (int i = 1; alphabeticalPos + i < spielfeld.size() && hoehe - i < spielfeld.get(alphabeticalPos + i).size()&&hoehe -i >=0; i++) {
            if (colorOfOrigin.equals(spielfeld.get(alphabeticalPos + i).get(hoehe - i))) {
                sameColorCount++;
            } else {
                break;
            }
        }
        return sameColorCount;
    }

    private static int fromLowerLeftToUpperRigth(List<List<String>> spielfeld, int alphabeticalPos, int hoehe, int sameColorCount, String colorOfOrigin) {
        Predicate<Integer> insideLowerBorders = (i) ->
                (hoehe - i >= 0 && alphabeticalPos - i >= 0
                        && spielfeld.get(alphabeticalPos - i).size() > hoehe - i);
        for (int i = 1; insideLowerBorders.test(i); i++) {
            if (colorOfOrigin.equals(spielfeld.get(alphabeticalPos - i).get(hoehe - i))) {
                sameColorCount++;
            } else {
                break;
            }
        }
        for (int i = 1; alphabeticalPos + i < spielfeld.size() && hoehe + i < spielfeld.get(alphabeticalPos + i).size(); i++) {
            if (colorOfOrigin.equals(spielfeld.get(alphabeticalPos + i).get(hoehe + i))) {
                sameColorCount++;
            } else {
                break;
            }
        }
        return sameColorCount;
    }

    private static boolean fourInLine(List<List<String>> spielfeld, int alphabeticalPos) {
        int counter = 0;
        for (int i = 1; stillPositionToCheck(spielfeld, alphabeticalPos, i); i++) {
            if (sameColor(spielfeld, alphabeticalPos, counter, i)) {
                counter++;
            } else {
                break;
            }
        }
        for (int i = -1; stillPositionToCheck(spielfeld, alphabeticalPos, i); i--) {
            if (sameColor(spielfeld, alphabeticalPos, counter, i)) {
                counter++;
            } else {
                break;
            }
        }
        return counter >= 3;
    }

    private static boolean sameColor(List<List<String>> spielfeld, int alphabeticalPos, int counter, int i) {
        int newestPos = spielfeld.get(alphabeticalPos).size() - 1;
        String origin = spielfeld.get(alphabeticalPos).get(newestPos);
        String toCheck = (spielfeld.get(alphabeticalPos + i).get(newestPos));
        return (origin.equals(toCheck));
    }

    private static boolean stillPositionToCheck(List<List<String>> spielfeld, int alphabeticalPos, int i) {
        if (spielfeld.size() > alphabeticalPos + i &&
                (alphabeticalPos + i) >= 0) {
            return spielfeld.get(alphabeticalPos).size() <= spielfeld.get(alphabeticalPos + i).size();
        }
        return false;
    }

    private static boolean fourInRow(List<String> row, int alphabeticalPos) {
        if (row.size() < 4) {
            return false;
        }
        int lastIndex = row.size() - 1;
        for (int i = lastIndex; lastIndex - i < 4; i--) {
            if (!row.get(i).equals(row.get(lastIndex))) {
                return false;
            }
        }
        return true;
    }
}
