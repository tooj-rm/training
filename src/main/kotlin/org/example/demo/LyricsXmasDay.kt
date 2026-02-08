package org.example.demo

class LyricsXmasDay {
    fun verse(verseNumber: Int): String {
        if(verseNumber == 2) {
            return """
                On the second day of Christmas
                My true love gave to me:
            """
        }

        return """
                On the first day of Christmas
                My true love gave to me:
            """
    }
}