package `fun`.coding.linfeng.hellokotlin.Exercises

open class Book(val title:String,val author:String) {
    private var currentPage: Int = 0
    open fun readPage(){
        currentPage++
    }
}

class EBook(title:String,author:String,val format:String="text"):Book(title,author){
    var wordRead=0
    override fun readPage() {
        wordRead+=250
    }
}