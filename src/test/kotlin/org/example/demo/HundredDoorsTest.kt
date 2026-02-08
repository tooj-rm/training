package org.example.demo

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.TestMethodOrder
import kotlin.math.sqrt
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class HundredDoorsTest {
    lateinit var hundredDoors: HundredDoors

    @BeforeTest
    fun setUp() {
        hundredDoors = HundredDoors()
    }

    @Test
    @Order(1)
    fun `all doors are closed`() {
        assertTrue { hundredDoors.doors.any { !it.opened } }
    }

    @Test
    @Order(2)
    fun `first pass`() {
        hundredDoors.visit(1)
        assertTrue { hundredDoors.doors.any { it.opened } }
    }

    @Test
    @Order(3)
    fun `second pass (#2, #4, #6)`() {
        hundredDoors.visit(2)
        assertTrue { hundredDoors.doors.filter { it.index % 2 == 0 }.any { !it.opened } }
    }

    @Test
    @Order(4)
    fun `third pass (#3, #6, #9)`() {
        hundredDoors.visit(3)
        assertTrue { hundredDoors.doors.filter { it.index % 3 == 0 }.any { !it.opened } }
        assertTrue(hundredDoors.doors[5].opened)
    }

    @Test
    @Order(5)
    fun `fourth pass (#4, #8, #12)`() {
        hundredDoors.visit(4)
        assertTrue { hundredDoors.doors.filter { it.index % 4 == 0 }.any { !it.opened } }
        assertFalse(hundredDoors.doors[11].opened)
    }

    @Test
    @Order(6)
    fun `fifth pass`() {
        hundredDoors.visit(5)
        assertTrue(hundredDoors.doors[9].opened)
        assertTrue(hundredDoors.doors[14].opened)
        assertFalse(hundredDoors.doors[19].opened)
    }

    @Test
    @Order(7)
    fun `last visit only perfect squares opened`() {
        hundredDoors.visit(100)

        hundredDoors.doors.forEach { door ->
            val sqrt = sqrt(door.index.toDouble())
            if (sqrt == sqrt.toInt().toDouble()) {
                assertTrue(door.opened, "Door ${door.index} should be open")
            } else {
                assertFalse(door.opened, "Door ${door.index} should be closed")
            }
        }
    }
}
