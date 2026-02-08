package org.example.demo

class LyricsXmasDay {
    fun verse(verseNumber: Int): String {
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
            """
    }
}