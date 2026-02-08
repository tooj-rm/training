package org.example.demo

class LyricsXmasDay {
    fun verse(verseNumber: Int): String {
        return listOf(
            verseHeader(verseNumber),
            verseBody(verseNumber)
        ).joinToString("\n")
    }

    fun verseHeader(verseNumber: Int): String {
        val verses = listOf(
            "first",
            "second",
            "third",
            "fourth",
            "fifth",
            "sixth",
            "seventh",
            "eighth",
            "ninth",
            "tenth",
            "eleventh",
            "twelfth"
        )

        return """
                On the ${verses[verseNumber - 1]} day of Christmas
                My true love gave to me:
            """.trimIndent()
    }

    fun verseBody(verseNumber: Int): String {
        val lines = listOf(
            "A partridge in a pear tree.",
            "Two turtle doves and",
            "Three french hens",
            "Four calling birds",
            "Five golden rings",
            "Six geese a-laying",
            "Seven swans a-swimming",
            "Eight maids a-milking",
            "Nine ladies dancing",
            "Ten lords a-leaping",
            "Eleven pipers piping",
            "Twelve drummers drumming"
        )

        return lines.subList(0, verseNumber)
            .reversed()
            .joinToString("\n")
    }

    fun print(): String {
        var lyrics = ""

        for (verseNumber in 1..12) {
            lyrics += verse(verseNumber)
            lyrics += "\n\n"
        }

        return lyrics
    }
}