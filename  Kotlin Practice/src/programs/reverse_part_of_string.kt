package programs

fun main(){
    println("Reverse 2 to 6 from : ${reversePartOfString("abcdefgh",2,6)}")
}

fun reversePartOfString(str:String,start:Int,end:Int) : StringBuilder{

    var p1 = start
    var p2 = end

    val reversedStr = StringBuilder(str)

    while(p1<p2){
        reversedStr.replace(p2,p2+1,str[p1].toString())
        reversedStr.replace(p1,p1+1,str[p2].toString())

        p1++
        p2--
    }


    return reversedStr




}