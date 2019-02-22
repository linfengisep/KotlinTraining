package `fun`.coding.linfeng.hellokotlin.Exercises

class Book(val title:String,val author:String,val year:Int, var pages:Int) {
    const val MAX_NUMBERS_BOOKS = 20

    fun getTitleAuthor():Pair<String,String>{
        return (title to author)
    }
    fun getTitleAuthorYear():Triple<String,String,Int>{
        return Triple(title,author,year)
    }
    fun canBorrow(booksToBorrow:Int):Boolean{
        return booksToBorrow < MAX_NUMBERS_BOOKS
    }

    fun printUrl(){
        print(BASE_URL+title+".html")
    }
    companion object {
        val BASE_URL = "www.saint-genevieve/library"
    }


   // fun String.hasSpaces() = find{it == ' '} !=null
}

fun Book.getWeight():Double{
    return this.pages*1.5
}

fun Book.tornPages(pagesToTear:Int){
    if(pages>pagesToTear)
    this.pages -=pagesToTear
    else pages=0
}

class Puppy(){
    fun playWithBook(book:Book){
        book.tornPages(Random().nextInt(book.pages))
    }
}

