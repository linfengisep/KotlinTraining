package `fun`.coding.linfeng.hellokotlin.Exercises.Spices

sealed class Spice(val name:String,val spiceness:String="mild",color:SpiceColor):SpiceColor by color{
    abstract fun prepareSpice()
}

class Curry(name:String = "curry", spiceness: String="mild", curryColor:SpiceColor=YellowSpiceColor):Spice(name,spiceness,curryColor),Grinder{
    override fun prepareSpice() {
        print("preparing spice")
    }
    override fun grind(){
        print("grinding it to powder")
    }
}

interface Grinder{
    fun grind()
}

interface SpiceColor{
    val color:Color
}

object YellowSpiceColor:SpiceColor{
    override val color= Color.YELLOW
}

enum class Color(val rgb:Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}
/*
val spices = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "Medium"),
        Spice("ginger", "mild"),
        Spice("red curry", "medium"),
        Spice("green curry", "mild"),
        Spice("hot pepper", "extremely spicy")
)
val spiceOnes = spices.filter{
    it.heat>3
}

*/