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
            lyrics.verseHeader(1)
        )
    }

    @Test
    fun `first two lines of second verse`() {
        assertVerse(
            """
                On the second day of Christmas
                My true love gave to me:
            """,
            lyrics.verseHeader(2)
        )
    }

    @Test
    fun `first two lines of any verse`() {
        assertVerse(
            """
                On the ninth day of Christmas
                My true love gave to me:
            """,
            lyrics.verseHeader(9)
        )
    }

    @Test
    fun `specific line for first verse`() {
        assertVerse(
            """
                A partridge in a pear tree.
            """,
            lyrics.verseBody(1)
        )
    }

    @Test
    fun `specific line for second verse`() {
        assertVerse(
            """
                Two turtle doves and
                A partridge in a pear tree.
            """,
            lyrics.verseBody(2)
        )
    }

    @Test
    fun `specific line for any verse`() {
        assertVerse(
            """
                Eight maids a-milking
                Seven swans a-swimming
                Six geese a-laying
                Five golden rings
                Four calling birds
                Three french hens
                Two turtle doves and
                A partridge in a pear tree.
            """,
            lyrics.verseBody(8)
        )
    }
}

private fun assertVerse(expected: String, actual: String) {
    assertEquals(expected.trimIndent(), actual)
}