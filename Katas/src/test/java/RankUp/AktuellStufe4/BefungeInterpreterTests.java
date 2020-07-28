package RankUp.AktuellStufe4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BefungeInterpreterTests {
    @Test
    @Disabled
    public void tests() {
        assertEquals("123456789", new BefungeInterpreter().interpret(
                ">987v>.v\n" +
                     "v456<  :\n" +
                     ">321 ^_@"));
    }
    @Test
    public void zahlenZuZahl() {
        assertEquals(
                "123456789",
                new BefungeInterpreter().interpret("987654321"));
    }
    @Test
    public void addition() {
        assertEquals(
                "123456717",
                new BefungeInterpreter().interpret("98+7654321"));
    }
    @Test
    public void subtraktion() {
        assertEquals(
                "12345671",
                new BefungeInterpreter().interpret("98-7654321"));
    }
    @Test
    public void multiplikation() {
        assertEquals(
                "123456772",
                new BefungeInterpreter().interpret("98*7654321"));
    }
    @Test
    public void validDivision() {
        assertEquals(
                "12345672",
                new BefungeInterpreter().interpret("21/7654321"));
    }
    @Test
    public void divideZeroPushNull() {
        assertEquals(
                "12345670",
                new BefungeInterpreter().interpret("20/7654321"));
    }
    @Test
    public void modulo() {
        assertEquals(
                "12345671",
                new BefungeInterpreter().interpret("98/7654321"));
    }
    @Test
    public void logicalNOTNotNullIsNull() {
        assertEquals(
                "12345670",
                new BefungeInterpreter().interpret("9!7654321"));
    }
    @Test
    public void logicalNOTNullIsOne() {
        assertEquals(
                "12345671",
                new BefungeInterpreter().interpret("0!7654321"));
    }
    @Test
    public void greaterThan() {
        assertEquals(
                "12345671",
                new BefungeInterpreter().interpret("98`7654321"));
    }
    @Test
    public void lessThan() {
        assertEquals(
                "12345670",
                new BefungeInterpreter().interpret("89`7654321"));
    }
    @Test
    public void moveRight() {
        assertEquals(
                "123456789",
                new BefungeInterpreter().interpret("98>7654321"));
    }
    @Test
    public void spaceDoesNothing() {
        assertEquals(
                "123456789",
                new BefungeInterpreter().interpret("9 8 7 6 5 4 3 2 1"));
    }
    @Test
    public void backSlashNDoesNothing() {
        assertEquals(
                "123456789",
                new BefungeInterpreter().interpret("9 8 \n7 6 5 4 3 2 1"));
    }
    @Test
    public void stop() {
        assertEquals(
                "789",
                new BefungeInterpreter().interpret("9 8 7@\n" +
                                                        "6 5 4 \n" +
                                                        "3 2 1 "));
    }
    @Test
    public void moveDown() {
        assertEquals(
                "789",
                new BefungeInterpreter().interpret("9 8 7v\n" +
                                                        "6 5 4v\n" +
                                                        "3 2 1 "));
    }
    @Test
    public void moveUp() {
        assertEquals(
                "789",
                new BefungeInterpreter().interpret("v>9 8 7@\n" +
                                                        ">^      \n"));
    }
    @Test
    public void moveRandom() {
        assertEquals(
                "",
                new BefungeInterpreter().interpret("v@ \n" +
                                                        ">?@\n" +
                                                        " @ "));
    }
    @Test
    public void moveRightAfter_() {
        assertEquals(
                "1",
                new BefungeInterpreter().interpret("_01@"));
    }
    @Test
    public void moveLeftAfter_() {
        assertEquals(
                "1",
                new BefungeInterpreter().interpret("1v \n" +
                                                        "@_2\n" +
                                                        "@2 "));
    }
    @Test
    public void moveDownAfterLineSign() {
        //=0
        assertEquals(
                "1",
                new BefungeInterpreter().interpret("1|0\n" +
                                                        " @ \n" ));
    }
    @Test
    public void moveUpAfterLineSign() {
        //!=0
        assertEquals(
                "1",
                new BefungeInterpreter().interpret("1v@ \n" +
                                                        " >|1\n" ));
    }
}

