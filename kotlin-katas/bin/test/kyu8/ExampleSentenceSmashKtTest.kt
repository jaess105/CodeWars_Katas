package kyu8

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class SentenceSmashKtTest {
    @Test
    fun validate() {
        assertEquals("Bilal Djaghout", smash(arrayOf("Bilal", "Djaghout")))
        assertEquals("hello world", smash(arrayOf("hello", "world")))
        assertEquals("hello amazing world", smash(arrayOf("hello", "amazing", "world")))
    }

    @Test
    fun validateEmpty() {
        assertEquals("", smash(arrayOf<String>()))
    }


    @Test
    fun validateOneWord() {
        assertEquals("Bilal", smash(arrayOf("Bilal")))
        assertEquals("Test", smash(arrayOf("Test")))
    }

    @Test
    @DisplayName("100 Random Test Cases")
    fun random_test() {
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z')

        (0..99).map {
            val testArr: Array<String> = (0..Random.nextInt(1, 15)).map {
                // random test word
                (1..Random.nextInt(1, 15)).map {
                    // random test char
                    charPool[Random.nextInt(0, charPool.size)]
                }.joinToString("")
            }.toTypedArray()
            assertEquals(testArr.joinToString(" "), smash(testArr))
        }
    }
}

internal class ExampleSentenceSmashKtTest {
    @Test
    @DisplayName("Test for two words")
    fun validate() {
        assertEquals("smash words", smash(arrayOf("smash", "words")))
    }

    @Test
    @DisplayName("No word should result in an empty String")
    fun validateEmpty() {
        assertEquals("", smash(arrayOf<String>()))
    }


    @Test
    @DisplayName("One word should result in a String without spaces")
    fun validateOneWord() {
        assertEquals("smash", smash(arrayOf("smash")))
    }
}

