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

    val counts: Map<Int, Int> = dice.groupingBy { it }.eachCount()
}

class Yatzy() {
    fun score(inputLine: String, category: Category): Int {
        val input = RollInput(inputLine, category)
        if (category == Category.SmallStraight && !input.dice.stream().allMatch { it in 1..5 }) {
            return 0
        }

        if (category == Category.LargeStraight && !input.dice.stream().allMatch { it in 2..6 }) {
            return 0
        }

        if (category == Category.Ones) {
            return input.counts[1] ?: 0
        }

        if (category == Category.Twos) {
            return (input.counts[2] ?: 0) * 2
        }

        if (category == Category.Threes) {
            return (input.counts[3] ?: 0) * 3
        }

        if (category == Category.Fours) {
            return (input.counts[4] ?: 0) * 4
        }

        if (category == Category.Fives) {
            return (input.counts[5] ?: 0) * 5
        }

        if (category == Category.Sixes) {
            return (input.counts[6] ?: 0) * 6
        }

        return input.dice.sum()
    }
}
