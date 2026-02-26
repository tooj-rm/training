package org.example.demo

enum class Category {
    Chance {
        override fun score(input: RollInput) = input.dice.sum()
    },

    Yatzy {
        override fun score(input: RollInput) =
            if (input.counts.values.any { it == 5 }) 50 else 0
    },

    Ones {
        override fun score(input: RollInput) = input.sumOf(1)
    },

    Twos {
        override fun score(input: RollInput) = input.sumOf(2)
    },

    Threes {
        override fun score(input: RollInput) = input.sumOf(3)
    },

    Fours {
        override fun score(input: RollInput) = input.sumOf(4)
    },

    Fives {
        override fun score(input: RollInput) = input.sumOf(5)
    },

    Sixes {
        override fun score(input: RollInput) = input.sumOf(6)
    },

    Pair {
        override fun score(input: RollInput) =
            input.highestOfAKind(2)?.times(2) ?: 0
    },

    TwoPairs {
        override fun score(input: RollInput): Int {
            val pairs = input.counts
                .filter { it.value >= 2 }
                .keys
                .sortedDescending()

            return if (pairs.size >= 2) pairs.take(2).sumOf { it * 2 } else 0
        }
    },

    ThreeOfAKind {
        override fun score(input: RollInput) =
            input.highestOfAKind(3)?.times(3) ?: 0
    },

    FourOfAKind {
        override fun score(input: RollInput) =
            input.highestOfAKind(4)?.times(4) ?: 0
    },

    SmallStraight {
        override fun score(input: RollInput) =
            if (input.dice.sorted() == listOf(1, 2, 3, 4, 5)) 15 else 0
    },

    LargeStraight {
        override fun score(input: RollInput) =
            if (input.dice.sorted() == listOf(2, 3, 4, 5, 6)) 20 else 0
    },

    FullHouse {
        override fun score(input: RollInput): Int {
            val hasThree = input.counts.values.any { it == 3 }
            val hasTwo = input.counts.values.any { it == 2 }
            return if (hasThree && hasTwo) input.dice.sum() else 0
        }
    };

    abstract fun score(input: RollInput): Int
}

data class RollInput(
    val input: String,
    val category: Category,
) {
    val dice: List<Int> = input.split(",").map { it.trim().toInt() }

    val counts: Map<Int, Int> = dice.groupingBy { it }.eachCount()

    fun sumOf(value: Int) = (counts[value] ?: 0) * value

    fun highestOfAKind(n: Int): Int? =
        counts
            .filter { it.value >= n }
            .keys
            .maxOrNull()
}

class Yatzy {
    fun score(inputLine: String, category: Category): Int {
        val input = RollInput(inputLine, category)
        return category.score(input)
    }
}
