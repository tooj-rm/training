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
}
