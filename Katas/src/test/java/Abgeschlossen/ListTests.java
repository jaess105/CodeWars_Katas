package JUnit;

import Kata.Line;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;



public class ListTests {
    @Test
    public void test1() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 1;
        assertEquals("Sheldon", new Line().WhoIsNext(names, n));
    }
    @Test
    public void test2() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 6;
        assertEquals("Sheldon", new Line().WhoIsNext(names, n));
    }
    //8301
    @Test
    public void test3() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 62;
        assertEquals("Rajesh", new Line().WhoIsNext(names, n));
    }
    @Test
    public void test4() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 8301;
        assertEquals("Rajesh", new Line().WhoIsNext(names, n));
    }
}
