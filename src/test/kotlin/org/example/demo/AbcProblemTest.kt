package org.example.demo

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AbcProblemTest {
    lateinit var abcProblem: AbcProblem

    @BeforeEach
    fun setUp() {
         abcProblem = AbcProblem(
            listOf(
                Block('B', 'O'),
                Block('X', 'K'),
                Block('D', 'Q'),
                Block('C', 'P'),
                Block('N', 'A'),
                Block('G', 'T'),
                Block('R', 'E'),
                Block('T', 'G'),
                Block('Q', 'D'),
                Block('F', 'S'),
                Block('J', 'W'),
                Block('H', 'U'),
                Block('V', 'I'),
                Block('A', 'N'),
                Block('O', 'B'),
                Block('E', 'R'),
                Block('F', 'S'),
                Block('L', 'Y'),
                Block('P', 'C'),
                Block('Z', 'M')
            )
        );
    }

    @Test
    fun `make letter A`() {
        assertTrue(abcProblem.canMakeWord("A"))
    }

    @Test
    fun `make word BARK`() {
        assertTrue(abcProblem.canMakeWord("BARK"))
    }

    @Test
    fun `cannot make word BOOK`() {
        assertFalse(abcProblem.canMakeWord("BOOK"))
    }

    @Test
    fun `can make word TREAT`() {
        assertTrue(abcProblem.canMakeWord("TREAT"))
    }

    @Test
    fun `cannot make word COMMON`() {
        assertFalse (abcProblem.canMakeWord("COMMON"))
    }

    @Test
    fun `can make word SQUAD`() {
        assertTrue(abcProblem.canMakeWord("SQUAD"))
    }

    @Test
    fun `can make word CONFUSE`() {
        assertTrue(abcProblem.canMakeWord("CONFUSE"))
    }

    @Test
    fun `case insensitive`() {
        assertTrue(abcProblem.canMakeWord("a"))
        assertTrue(abcProblem.canMakeWord("barK"))
        assertFalse (abcProblem.canMakeWord("BoOK"))
    }
}
