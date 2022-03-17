package kyu8

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ReplaceKtTest {
    @Test
    fun testFixed() {
        assertEquals("H!!", replace("Hi!"));
        assertEquals("!H!! H!!", replace("!Hi! Hi!"));
        assertEquals("!!!!!", replace("aeiou"));
        assertEquals("!BCD!", replace("ABCDE"));
    }
}