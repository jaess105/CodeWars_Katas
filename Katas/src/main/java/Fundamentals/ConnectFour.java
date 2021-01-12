package Fundamentals;

import java.util.ArrayList;
import java.util.List;

/**
 * Connect Four
 * Take a look at wiki description of Connect Four game:
 *
 * Wiki Connect Four
 *
 * The grid is 6 row by 7 columns, those being named from A to G.
 *
 * You will receive a list of strings showing the order of the pieces which dropped in columns:
 *
 * List<String> myList = new ArrayList<String>(Arrays.asList(
 *     "A_Red",
 *     "B_Yellow",
 *     "A_Red",
 *     "B_Yellow",
 *     "A_Red",
 *     "B_Yellow",
 *     "G_Red",
 *     "B_Yellow"
 * ));
 * The list may contain up to 42 moves and shows the order the players are playing.
 *
 * The first player who connects four items of the same color is the winner.
 *
 * You should return "Yellow", "Red" or "Draw" accordingly.
 */

public class ConnectFour {
    //6x7
    public static String whoIsWinner(List<String> piecesPositionList) {
        List<List<String>> spielfeld= new ArrayList<>();
        for(int i=0;i<7;i++){
            spielfeld.add(new ArrayList<>());
        }
        piecesPositionList.stream()
                .map(s->s.split("_"))
                .forEach(arr->spielfeld.get(arr[0].charAt(0)-65).add(arr[1]));
        // retrun "Red" or "Yellow" or "Draw"
        return "Draw";
    }
}
