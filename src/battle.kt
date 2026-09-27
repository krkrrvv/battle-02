fun main() {
//    val playerField = createEmptyField()
//    val enemyField = createEmptyField(8)
//
//    playerField[3][2] = '#'
//
//    printField(playerField, "Ваше поле")
//    printField(enemyField, "Поле противника", showShips = false)

    val playerField = createEmptyField(13)
    playerField[3][2] = '#'
    playerField[3][3] = '#'

    val enemyField = createEmptyField(13)
    enemyField[5][3] = '#'
    enemyField[5][5] = 'X'

    printField(playerField, "Ваше поле", debug = true)

    printBothFields(playerField, enemyField)
}
fun createEmptyField(size: Int = 10): Array<CharArray> {
    return Array(size) { CharArray(size) { '.' } }
}
fun printField(field: Array<CharArray>, title: String, showShips: Boolean = true, debug: Boolean = false) {
    println("=== $title ===")
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
fun printBothFields(player: Array<CharArray>, enemy: Array<CharArray>, showEnemyShips: Boolean = false) {
    if (player.size != enemy.size) {
        print("Ошибка! Поля должны быть одинакового размера!")
        return
    }
    val size = player.size
    println("=== Ваше поле ===               === Поле противника ===")
    print("   ")
    for (c in 0 until size) print("$c ")
    print("     ")
    print("   ")
    for(c in 0 until size) print("$c ")
    println()

    for(r in 0 until size) {
        print("$r  ")
        for(c in 0 until size) print("${player[r][c]} ")
        print("     ")
        print("$r  ")
        for(c in 0 until size) {
            val a1 = enemy[r][c]
            val show = when {
                !showEnemyShips && a1 == '#' -> '.'
                else -> a1
            }
            print("$show ")
        }
        println()
    }
}
