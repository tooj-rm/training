package org.example.demo

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class YatzyTest {
    @ParameterizedTest
    @CsvSource(
        "'1,1,3,3,6',14",
        "'4,5,5,6,1',21",
    )
    fun chance(input: String, expected: Int) {
        // Given / When
        val yatzy = Yatzy()
        val score = yatzy.score(input, Category.Chance)

        // Then
        assertEquals(expected, score)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5',15",
        "'1,2,3,4,6',0",
    )
    fun `small straight`(input: String, expected: Int) {
        // Given / When
        val yatzy = Yatzy()
        val score = yatzy.score(input, Category.SmallStraight)

        // Then
        assertEquals(expected, score)
    }

    @ParameterizedTest
    @CsvSource(
        "'2,3,4,5,6',20",
        "'1,3,4,5,6',0",
    )
    fun `large straight`(input: String, expected: Int) {
        // Given / When
        val yatzy = Yatzy()
        val score = yatzy.score(input, Category.LargeStraight)

        // Then
        assertEquals(expected, score)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,1,2,4,4',Fours,8",
        "'2,3,2,5,1',Twos,4",
        "'3,3,3,4,5',Ones,0",
    )
    fun `ones, twos, threes, fours, fives, sixes`(input: String, catLabel: String, expected: Int) {
        // Given / When
        val category = Category.valueOf(catLabel)
        val yatzy = Yatzy()
        val score = yatzy.score(input, category)

        // Then
        assertEquals(expected, score)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5',Pair,0",
        "'3,3,3,4,4',Pair,8",
        "'1,1,6,2,6',Pair,12",
        "'3,3,3,4,1',Pair,6",
        "'3,3,3,3,1',Pair,6",
    )
    fun pair(input: String, catLabel: String, expected: Int) {
        // Given / When
        val category = Category.valueOf(catLabel)
        val yatzy = Yatzy()
        val score = yatzy.score(input, category)

        // Then
        assertEquals(expected, score)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,1,2,3,3',8",
        "'1,1,2,3,4',0",
        "'1,1,2,2,2',6",
        "'3,3,3,3,1',0",
    )
    fun twoPairs(input: String, expected: Int) {
        // Given / When
        val yatzy = Yatzy()
        val score = yatzy.score(input, Category.TwoPairs)

        // Then
        assertEquals(expected, score)
    }

    @ParameterizedTest
    @CsvSource(
        "'3,3,3,4,5',9",
        "'3,3,4,5,6',0",
        "'3,3,3,3,1',9",
    )
    fun threeOfAKind(input: String, expected: Int) {
        // Given / When
        val yatzy = Yatzy()
        val score = yatzy.score(input, Category.ThreeOfAKind)

        // Then
        assertEquals(expected, score)
    }

    @ParameterizedTest
    @CsvSource(
        "'2,2,2,2,5',8",
        "'2,2,2,5,5',0",
        "'2,2,2,2,2',8",
    )
    fun fourOfAKind(input: String, expected: Int) {
        // Given / When
        val yatzy = Yatzy()
        val score = yatzy.score(input, Category.FourOfAKind)

        // Then
        assertEquals(expected, score)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,1,2,2,2',8",
        "'2,2,3,3,4',0",
        "'4,4,4,4,4',0",
    )
    fun fullHouse(input: String, expected: Int) {
        // Given / When
        val yatzy = Yatzy()
        val score = yatzy.score(input, Category.FullHouse)

        // Then
        assertEquals(expected, score)
    }
}
