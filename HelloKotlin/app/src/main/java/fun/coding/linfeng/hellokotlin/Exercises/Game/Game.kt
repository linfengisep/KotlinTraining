package `fun`.coding.linfeng.hellokotlin.Exercises.Game

enum class Directions{
    NORTH,
    SOUTH,
    WEST,
    EAST,
    START,
    END
}

class Game(){
    var paths = mutableListOf<Directions>(Directions.START)
    fun north() = paths.add(Directions.NORTH)
    fun south() = paths.add(Directions.SOUTH)
    fun east() = paths.add(Directions.EAST)
    fun west() = paths.add(Directions.WEST)

    fun end():Boolean {
        paths.add(Directions.END)
        print("Game Over")
        print(paths)
        paths.clear()
        return false
    }
}

fun main(args:Array<String>){
    val game = Game()
    print(game.paths)
    game.east()
    game.south()
    game.north()
    game.west()
    print(game.paths)
}