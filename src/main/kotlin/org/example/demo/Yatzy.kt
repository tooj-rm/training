package org.example.demo

enum class Category {
    Chance,
    Yatzy,
    Ones,
    Twos,
    Threes,
    Fours,
    Fives,
    Sixes,
    Pair,
    TwoPairs,
    ThreeOfAKind,
    FourOfAKind,
    SmallStraight,
    LargeStraight,
    FullHouse
}

data class RollInput(
    val input: String,
    val category: Category,
) {
    val dice: List<Int> = input.split(',').map { it.toInt() }
}

class Yatzy() {
    fun score(inputLine: String, category: Category): Int {
        val input = RollInput(inputLine, category)
        return input.dice.sum()
    }
}
