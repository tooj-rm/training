package org.example.demo

class BalancedParentheses {
    val parenthesis = Pair('(', ')')
    val bracket = Pair('[', ']')
    val brace = Pair('{', '}')

    val pairs = mapOf(
        parenthesis.second to parenthesis.first,
        bracket.second to bracket.first,
        brace.second to brace.first
    )

    fun check(input: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (char in input) {
            if (char == parenthesis.first || char == bracket.first || char == brace.first) {
                stack.add(char)
            } else if (stack.isEmpty() || stack.removeLast() != pairs[char]) {
                return false
            }
        }

        return stack.isEmpty()
    }
}
