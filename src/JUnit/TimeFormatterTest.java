package JUnit;

import Kata.TimeFormatter;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeFormatterTest {
    @Test
    public void Test1() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
    }
    @Test
    public void Test2() {
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
    }
    @Test
    public void Test3() {
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
    }
    @Test
    public void Test4() {
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
    }
    @Test
    public void Test5() {
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }
}

