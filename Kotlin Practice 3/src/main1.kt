
//QA-1

fun main(){

    val textArr = arrayOf(11,1,13,21,3,7)
    val patternArr = arrayOf(11,3,7,1)

    val textArr2 = arrayOf(10,5,2,23,19)
    val patternArr2 = arrayOf(19,5,3)

    val textArr3 = arrayOf(-25,0,25,-10)
    val patternArr3 = arrayOf(25,-25,0,-10)

    isSubset(patternArr,patternArr.size,textArr,textArr.size)
    isSubset(patternArr2,patternArr2.size,textArr2,textArr2.size)
    isSubset(patternArr3,patternArr3.size,textArr3,textArr3.size)
}


fun isSubset(patternArr:Array<Int>,patternArrLen:Int,textArr:Array<Int>,textArrLen:Int){

    var isSubset = false
    for(patternArrIndex in patternArr.indices){
        for(textArrIndex in textArr.indices){

            if(patternArr[patternArrIndex] == textArr[textArrIndex]){
                isSubset = true
                break
            }

            isSubset = false
        }
    }


    if(isSubset)
      println("yes")
    else
        println("no")
}


