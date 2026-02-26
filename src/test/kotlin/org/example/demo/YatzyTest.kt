package org.example.demo

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
}
