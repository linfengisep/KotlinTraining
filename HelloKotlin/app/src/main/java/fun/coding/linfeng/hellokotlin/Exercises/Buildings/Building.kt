package `fun`.coding.linfeng.hellokotlin.Exercises.Buildings

class Building<out T:BaseBuildingMaterial>(val buildingMaterial: T) {
    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded
    fun build(){
        println("mess")
    }
}