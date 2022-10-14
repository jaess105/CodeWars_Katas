package stufe4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RangeTest {
    @Test
    public void test1() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", Range.rangeExtraction(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
    }

    @Test
    void test2() {
        assertEquals("-3--1,2,10,15,16,18-20", Range.rangeExtraction(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}));
    }
}