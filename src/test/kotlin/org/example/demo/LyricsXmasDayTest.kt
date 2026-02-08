package org.example.demo

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class LyricsXmasDayTest {
    lateinit var lyrics: LyricsXmasDay

    @BeforeTest
    fun setUp() {
        lyrics = LyricsXmasDay()
    }

    @Test
    fun `first two lines of first verse`() {
        assertVerse(
            """
                On the first day of Christmas
                My true love gave to me:
            """,
            lyrics.verse(1)
        )
    }

    @Test
    fun `first two lines of second verse`() {
        assertVerse(
            """
                On the second day of Christmas
                My true love gave to me:
            """,
            lyrics.verse(2)
        )
    }

    @Test
    fun `first two lines of any verse`() {
        assertVerse(
            """
                On the ninth day of Christmas
                My true love gave to me:
            """,
            lyrics.verse(9)
        )
    }
}

private fun assertVerse(expected: String, actual: String) {
    assertEquals(expected.trimIndent(), actual)
}