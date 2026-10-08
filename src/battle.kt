fun main() {
//    val playerField = createEmptyField()
//    val enemyField = createEmptyField(8)
//
//    playerField[3][2] = '#'
//
//    printField(playerField, "Ваше поле")
//    printField(enemyField, "Поле противника", showShips = false)
    val player = Player()
    player.name = "Вы"

    player.registerShot(true)    // попал
    player.registerShot(false)   // промах
    player.registerShot(true)    // попал

    println(player.status())

    player.takeDamage()
    player.takeDamage()
    println(player.shipsLeft)    // 18
    println(player.isAlive())    // true

    player.reset()
    println(player.status())

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
fun printBothFields(player: Player, enemy: Player, showEnemyShips: Boolean = false) {
    if (player.field.size != enemy.field.size) {
        print("Ошибка! Поля должны быть одинакового размера!")
        return
    }
    val size = player.field.size
    println("=== Ваше поле ===               === Поле противника ===")
    print("   ")
    for (c in 0 until size) print("$c ")
    print("     ")
    print("   ")
    for(c in 0 until size) print("$c ")
    println()

    for(r in 0 until size) {
        print("$r  ")
        for(c in 0 until size) print("${player.field[r][c]} ")
        print("     ")
        print("$r  ")
        for(c in 0 until size) {
            val a1 = enemy.field[r][c]
            val show = when {
                !showEnemyShips && a1 == '#' -> '.'
                else -> a1
            }
            print("$show ")
        }
        println()
    }
}
