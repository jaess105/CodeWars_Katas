package RankUp.AktuellStufe5;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerSumDigTests {

    private static void testing(long act, long exp) {
        assertEquals(exp, act);
    }
    @Test
    public void test81() {
        testing(PowerSumDig.powerSumDigTerm(1), 81);
    }
    @Test
    public void test512() {
        testing(PowerSumDig.powerSumDigTerm(2), 512);
    }
/*    @Test
    public void test2401() {
        testing(PowerSumDig.powerSumDigTerm(3), 2401);

    }
    @Test
    public void test4913() {
        testing(PowerSumDig.powerSumDigTerm(4), 4913);
    }
    */
}