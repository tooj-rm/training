package org.example.demo

class AbcProblem(val blocks: List<Block>) {
    fun canMakeWord(word: String): Boolean {
        val charSequence = word.lowercase().toCharArray()
        val blocksUsed = mutableListOf<Block>()

        for (char in charSequence) {
            val block = blocks.find { !it.alreadyUsed && it.contains(char) }
            if (block == null) {
                continue
            }
            block.markAsUsed()
            blocksUsed.add(block)
        }

        return blocksUsed.size == charSequence.size
    }
}

class Block(
    val letter1: Char,
    val letter2: Char,
) {
    var alreadyUsed: Boolean = false
        private set

    fun contains(letter: Char): Boolean {
        return letter.lowercase() == letter1.lowercase() || letter.lowercase() == letter2.lowercase()
    }

    fun markAsUsed() {
        alreadyUsed = true
    }
}
