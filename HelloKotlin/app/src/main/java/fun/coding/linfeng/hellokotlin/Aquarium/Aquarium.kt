package `fun`.coding.linfeng.hellokotlin.Aquarium

class Aquarium(var height:Int=20,var width:Int=30,var length:Int=100){

    var volume : Int
        get(){
            return height*width*length/1000
        }
    set(value){ height = (value*1000)/(width*length) }

    var water = volume * 0.9

    constructor(numberOfFish:Int):this(){
        val water = numberOfFish * 2000
        val tank = water + water *0.1
        height = (tank/length*width).toInt()
    }
}

/*
*
*
class Aquarium(height:Int,width:Int,length:Int){
    var height:Int = height
    var width:Int = width
    var length:Int = length

    var volume : Int
        get(){
            return height*width*length/1000
        }
    set(value){ height = (value*1000)/(width*length) }
}*/