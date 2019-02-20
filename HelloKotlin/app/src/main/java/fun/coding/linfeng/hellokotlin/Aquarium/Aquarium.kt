package `fun`.coding.linfeng.hellokotlin.Aquarium

class Aquarium{
    var height:Int = 20
    var width:Int = 30
    var length:Int = 40

    var volume : Int
        get(){
            return height*width*length/1000
        }
    set(value){ height = (value*1000)/(width*length) }
}