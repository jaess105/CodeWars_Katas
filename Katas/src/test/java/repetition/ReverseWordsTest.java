package repetition;

import Abgeschlossen.Kata;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {

// TODO: Replace examples and use TDD development by writing your own tests

        @Test
        public void exampleCases() {
            assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", ReverseWords.reverseWords("The quick brown fox jumps over the lazy dog."));
            assertEquals("elppa", ReverseWords.reverseWords("apple"));
            assertEquals("a b c d", ReverseWords.reverseWords("a b c d"));
            assertEquals("elbuod  decaps  sdrow", ReverseWords.reverseWords("double  spaced  words"));
        }


}