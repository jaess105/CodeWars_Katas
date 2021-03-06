package stufe5;


import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;


class MaxTest {


    @Test
    public void testEmptyArray() throws Exception {
        assertEquals("Empty arrays should have a max of 0", 0, Max.sequence(new int[]{}));
    }

    @Test
    public void testExampleArray() throws Exception {
        assertEquals("Example array should have a max of 6", 6, Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    void stepOverValley() {
        assertEquals("Should return 23", 23, Max.sequence(new int[]{-1, 1, 2, 6, -1, -2, -3, 20}));
    }

}