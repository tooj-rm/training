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
        assertEquals(
            """
                On the first day of Christmas
                My true love gave to me:
            """,
            lyrics.verse(1)
        )
    }

    @Test
    fun `first two lines of second verse`() {
        assertEquals(
            """
                On the second day of Christmas
                My true love gave to me:
            """,
            lyrics.verse(2)
        )
    }
}