package org.example.demo

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BalancedParenthesesTest {
    lateinit var balancedParentheses: BalancedParentheses;

    @BeforeTest
    fun setUp() {
        balancedParentheses = BalancedParentheses()
    }

    @Test
    fun `{{)(}}} is not balanced`() {
        assertFalse(balancedParentheses.check("{{)(}}"))
    }

    @Test
    fun `({)} is not balanced`() {
        assertFalse(balancedParentheses.check("({)}"))
    }

    @Test
    fun `3rd input is balanced`() {
        assertTrue(balancedParentheses.check("[({})]"))
    }

    @Test
    fun `4st input is balanced()`() {
        assertTrue(balancedParentheses.check("{}([])"))
    }

    @Test
    fun `5st is balanced`() {
        assertTrue(balancedParentheses.check("{()}[[{}]]"))
    }
}
