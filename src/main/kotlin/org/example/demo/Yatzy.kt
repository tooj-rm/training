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

class Yatzy(
    val d1: Int,
    val d2: Int,
    val d3: Int,
    val d4: Int,
    val d5: Int
) {
    fun score(category: Category): Int {
        return d1 + d2 + d3 + d4 + d5
    }
}
