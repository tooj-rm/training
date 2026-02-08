package org.example.demo

class HundredDoors {
    val doors: List<Door> = (1..100).map { Door(it) }

    fun visit(visitTimes: Int) {
        var times = 1

        while (times <= visitTimes) {
            doors.forEachIndexed { index, door ->
                if ((index + 1) % times == 0) {
                    door.toggle()
                }
            }
            times +=1
        }
    }
}

class Door(val index: Int) {
    var opened: Boolean = false
        private set

    fun toggle() {
        opened = !opened
    }
}
