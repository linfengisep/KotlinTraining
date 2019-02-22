package `fun`.coding.linfeng.hellokotlin.Aquarium

data class Fish(var name:String)

fun main(args:Array<String>){
    fishExample()
}

fun fishExample(){
    val fish = Fish("Splashy")
    myWith(fish.name){
        println(this.capitalize())
    }
}

fun myWith(name:String,block:String.()-> Unit){
    name.block()
}