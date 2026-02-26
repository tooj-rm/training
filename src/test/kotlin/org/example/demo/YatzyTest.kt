package org.example.demo

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test
import kotlin.test.assertEquals

class YatzyTest {
    @Test
    fun `small straight`() {
        // Given / When
        val yatzy = Yatzy(1, 2, 3, 4, 5)
        val score = yatzy.score(Category.SmallStraight)

        // Then
        assertEquals(15, score)
    }

    @Test
    fun `large straight`() {
        // Given / When
        val yatzy = Yatzy(2, 3, 4, 5, 6)
        val score = yatzy.score(Category.LargeStraight)

        // Then
        assertEquals(20, score)
    }

    @ParameterizedTest
    @CsvSource(
        "1,1,3,3,6,14",
        "4,5,5,6,1,21"
    )
    fun `chance`(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int, expected: Int) {
        // Given / When
        val yatzy = Yatzy(d1, d2, d3, d4, d5)
        val score = yatzy.score(Category.Chance)

        // Then
        assertEquals(expected, score)
    }
}
