class Player {
    var name: String = ""
    var field: Array<CharArray> = Array(10) { CharArray(10) { '.' } }

    var shots: Int = 0
    var hits: Int = 0
    var shipsLeft: Int = 20

    fun printField(showShips: Boolean = true, debug: Boolean = false) {
        println("=== Поле игрока $name ===")
        val size = field.size
        if(debug) {
            val border = "   " + "+" + "----+".repeat(size)
            println(border)
            for (r in 0 until size) {
                print("$r  |")
                for (c in 0 until size) {
                    val a = field[r][c]
                    val show = when {
                        !showShips && a == '#' -> '.'
                        else -> a
                    }
                    print(" $show  |")
                }
                println()
                println(border)
            }
        }
        else {
            print("   ")
            for (c in field.indices) print("$c ")
            println()
            for (r in field.indices) {
                print("$r  ")
                for (c in field[r].indices) {
                    val a = field[r][c]
                    val show = when {
                        !showShips && a == '#' -> '.'
                        else -> a
                    }
                    print("$show ")
                }
                println()
            }
        }
    }

    fun printStats() {
        println(status())
    }
    fun isAlive(): Boolean {
        return shipsLeft > 0
    }
    fun accuracy(): Double {
        if (shots == 0) return 0.0
        return hits * 100.0 / shots
    }
    fun status(): String {
        return "Игрок $name: палуб осталось $shipsLeft, выстрелов $shots, попаданий $hits, точность ${String.format("%.1f", accuracy())}%"
    }
    fun takeDamage(): Boolean {
        shipsLeft--
        return isAlive()
    }
    fun registerShot(hit: Boolean) {
        shots++
        if (hit) hits++
    }
    fun reset() {
        shots = 0
        hits = 0
        shipsLeft = 20
        for (r in field.indices) {
            for (c in field[r].indices) {
                field[r][c] = '.'
            }
        }
    }
}