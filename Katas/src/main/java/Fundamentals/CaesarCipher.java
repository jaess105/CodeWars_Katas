package Fundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/5508249a98b3234f420000fb/train/java
 */
public class CaesarCipher {
    private enum UpOrDown {
        UP, DOWN;
    }

    public static List<String> movingShift(String str, int shift) {
        String result = modifiingTheString(shift, str, UpOrDown.DOWN);
        return toList(result);
    }

    public static String demovingShift(List<String> s, int shift) {
        String str = s.stream().collect(Collectors.joining());
        return modifiingTheString(shift, str, UpOrDown.UP);
    }

    private static String modifiingTheString(int shift, String str, UpOrDown operation) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char cAt = str.charAt(i);
            if (!Character.isLetter(cAt)) {
                result += cAt;
            } else {
                int shiftBy = (shift + i) % 26;
                result += getChangedChar(cAt, shiftBy, operation);
            }
        }
        return result;
    }

    private static String getChangedChar(char cAt, int shiftBy, UpOrDown operation) {
        int newCharValue = cAt + (operation.equals(UpOrDown.DOWN) ? +shiftBy : -shiftBy);
        if (operation.equals(UpOrDown.UP)
                && ('a' <= cAt && newCharValue < 'a' || newCharValue < 'A' && cAt <= 'Z')) {
            newCharValue = (char) (newCharValue + 26);
        } else if ('a' <= cAt && newCharValue > 'z' || newCharValue > 'Z' && cAt <= 'Z') {
            newCharValue = (newCharValue - 26);
        }
        return "" + (char) newCharValue;
    }

    private static List<String> toList(String str) {
        List<String> list = new ArrayList<>(5);
        Integer splitSize = str.length() / 4;
        while (str.length() - (splitSize - 1) * 4 < splitSize) {
            splitSize -= 1;
        }
        Integer finalSplitSize = splitSize;
        IntStream.range(0, 4).forEach(
                i -> list.add(str.substring(i * finalSplitSize, (i + 1) * (finalSplitSize))));
        list.add(str.substring(finalSplitSize * 4));
        return list;
    }
}