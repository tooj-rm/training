package org.example.demo

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test
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

    @Test
    fun `small straight`() {
        // Given / When
        val yatzy = Yatzy()
        val score = yatzy.score("1,2,3,4,5", Category.SmallStraight)

        // Then
        assertEquals(15, score)
    }

    @Test
    fun `large straight`() {
        // Given / When
        val yatzy = Yatzy()
        val score = yatzy.score("2,3,4,5,6", Category.LargeStraight)

        // Then
        assertEquals(20, score)
    }
}
