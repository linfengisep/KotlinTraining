package `fun`.coding.linfeng.hellokotlin.Exercises

fun main(args:Array<String>){
    val birthday = getBirthday()
    println("\n Your fortune is: ${getFortune(birthday)}")
}

fun getBirthday():Int{
    println("Enter your birthday:")
    return readLine()!!.toIntOrNull()?:1
}

fun getFortune(birthday:Int):String{
    val list:List<String> = listOf("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
    )

    val index = when (birthday){
        in 28..31 -> 2
        in 1..7 -> 4
        else -> birthday.rem(list.size)
    }
    return list[index]
}

fun shouldChangeWater(day:String,temperature:Int=22, dirty:Int=20):Boolean{
    return when{
        isTooHot(temperature) -> true
        isSunday(day) -> true
        isDirty(dirty) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int)=temperature>30
fun isDirty(dirty: Int)=dirty>20
fun isSunday(day: String)=day=="Sunday"

fun canAddFish(tankSize: Double, currentFish:List<Int>,fishSize:Int = 2,hasDecoration:Boolean = true):Boolean{
    return tankSize*(if(hasDecoration) 0.8 else 1.0) > currentFish.sum()+ fishSize
}

