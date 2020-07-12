package RankUp.Aktuell;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BefungeInterpreterTests {
    @Test
    @Disabled
    public void tests() {
        assertEquals(
                "123456789",
                new BefungeInterpreter().interpret(">987v>.v\nv456<  :\n>321 ^ _@"));

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
}
