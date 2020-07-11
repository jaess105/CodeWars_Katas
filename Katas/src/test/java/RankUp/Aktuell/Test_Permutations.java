package RankUp.Aktuell;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Permutations {


       @Test
       public void example1() {
           assertThat(  Permutations.singlePermutations("a").stream()
                   .sorted()
                   .collect(Collectors.toList()))
                   .isEqualTo(new ArrayList<String>(Arrays.asList("a")));
            }

            @Test
            public void example2() {
                assertThat( Permutations.singlePermutations("ab").stream()
                        .sorted()
                        .collect(Collectors.toList()) )
                        .isEqualTo(new ArrayList<String>(Arrays.asList("ab","ba")));
            }

            @Test
            public void example3() {
                assertThat(Permutations.singlePermutations("aabb").stream()
                        .sorted()
                        .collect(Collectors.toList()) )
                        .isEqualTo(new ArrayList<String>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")));
            }
    @Test
    public void example4() {
        assertThat(Permutations.singlePermutations("aabbc").stream()
                .sorted()
                .collect(Collectors.toList()) )
                .isEqualTo(new ArrayList<String>(Arrays.asList("aabbc", "ababc", "abbac", "baabc", "babac", "bbaac"
                        ,"aabcb", "abacb", "abbca", "baacb", "babca", "bbaca"
                        ,"aacbb", "abcab", "abcba", "bacab", "bacba", "bbcaa"
                        ,"acabb", "acbab", "acbba", "bcaab", "bcaba", "bcbaa"
                        ,"caabb", "cabab", "cabba", "cbaab", "cbaba", "cbbaa").stream().distinct().collect(Collectors.toList())));
    }
}
