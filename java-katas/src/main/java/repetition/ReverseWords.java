package repetition;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseWords {
    public static String reverseWords(final String original) {
        return original.equals(Pattern.compile("*( )"))?" ":Arrays.stream(original.split(" "))
                .map(x->new StringBuilder(x).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
