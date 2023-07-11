import java.util.*

fun main(){
    val s = "Rohan navlakhe"
    println(reverseStr(s))

    var s2 = StringBuffer()
    s.toSet().joinTo(s2,separator = "")
    println(s2)

    println(removeDuplicates(s))

    val arr = arrayOf(20,50,8,12)
    val arr2 = arrayOf(-25,500,74,-25)
    val arr3 = arrayOf(58,879,-58,47,2,0,-96,2579,9874,-36)
    var arr4 = arrayOf(2,10,85,-25,500,1,2,36)  //sorted [-25,1,2,2,10,36,85,500)


    bubbleSort(arr)
    bubbleSort(arr2)
    bubbleSort(arr3)
    bubbleSort(arr4)

    println("${arr3.contentToString()} has 0 : ${binarySearch(arr3,0)}")
    println("${arr3.contentToString()} has 9874 : ${binarySearch(arr3,9874)}")
    println("${arr3.contentToString()} has -36 : ${binarySearch(arr3,-36)}")
    println("${arr3.contentToString()} has -58 : ${binarySearch(arr3,-58)}")
    println("${arr3.contentToString()} has 58 : ${binarySearch(arr3,58)}")
    println("${arr3.contentToString()} has 2 : ${binarySearch(arr3,2)}")
    println("${arr3.contentToString()} has 400 : ${binarySearch(arr3,400)}")
    println("${arr3.contentToString()} has -1 : ${binarySearch(arr3,-1)}")


    println("Index of 2 : ${binarySearchIndexOf(arr4,2)}")
    println("Index of -25 : ${binarySearchIndexOf(arr4,-25)}")
    println("Index of 1000 : ${binarySearchIndexOf(arr4,1000)}")
    println("Index of 36 : ${binarySearchIndexOf(arr4,36)}")

    println("Arrays.binarySearch, index of 2 : ${Arrays.binarySearch(arr4,2)}")
    println("Arrays.binarySearch, index of -25 : ${Arrays.binarySearch(arr4,-25)}")
    println("Arrays.binarySearch, index of 1000 : ${Arrays.binarySearch(arr4,1000)}")
    println("Arrays.binarySearch, index of 36 : ${Arrays.binarySearch(arr4,36)}")


}

private fun reverseStr(string: String) : String{
    var reversedStr = ""
    for(i in string.length-1 downTo 0){
        reversedStr += string[i]
    }

    return reversedStr
}

private fun removeDuplicates(string: String):String{

    var newStr = ""

    string.forEach {
        if(!newStr.contains(it))
            newStr += it
    }

    return newStr
}

private fun bubbleSort(arr:Array<Int>){
    for(i in 0 until arr.size-1){
        for(j in i+1 until arr.size){
            if(arr[j] < arr[i]){
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }

    println("Sorted Array : ${arr.contentToString()}")
}

private fun binarySearch(array:Array<Int>,valueExists:Int):Boolean{

    var arr = array
    Arrays.sort(arr)
    while (arr.isNotEmpty()){
        if(arr[arr.size/2] == valueExists)
            return true
        else if(valueExists < arr[arr.size/2])
            arr = arr.sliceArray(0 until arr.size/2)
        else
            arr = arr.sliceArray((arr.size/2) + 1 until arr.size)

    }

    return false
}

private fun binarySearchIndexOf(array:Array<Int>, valueToFind:Int):Int{

    var arr = array
    Arrays.sort(arr)
    var lowerIndex = 0
    var higherIndex = arr.size - 1
    var searchAtIndex = (lowerIndex + higherIndex) / 2

    while (lowerIndex <= higherIndex){

        if(arr[searchAtIndex] == valueToFind)
            return searchAtIndex
        else if(valueToFind > arr[searchAtIndex]){
            lowerIndex = searchAtIndex + 1
        } else{
            higherIndex = searchAtIndex - 1
        }

        searchAtIndex = (lowerIndex + higherIndex) / 2
    }

    return -1
}