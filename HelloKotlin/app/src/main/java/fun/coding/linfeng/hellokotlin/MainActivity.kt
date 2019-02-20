package `fun`.coding.linfeng.hellokotlin

import `fun`.coding.linfeng.hellokotlin.Aquarium.Aquarium

fun main(args: Array<String>) {
    buildAquarium()
}

fun buildAquarium(){
    val myAquarium = Aquarium()
    println("aquarium length: ${myAquarium.length}"+
            "aquarium width: ${myAquarium.width}"+
            "aquarium height: ${myAquarium.height}"
    )

    println("aquarium volue:*${myAquarium.volume}")
}
