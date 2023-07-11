package programs

fun main(){

    val countOf0FromLast = 0

    val arr = intArrayOf(1,3,0,5,4,0,2,0,0)
    //1,3,5,4,0,2,0,0,0
    //1,3,5,4,2,0,0,0,0

    solution(arr)




}

fun solution(arr:IntArray){

    var j = 0

    arr.forEachIndexed { index, value ->
        if(arr[index] != 0){
            swap(arr,index,j)
            j++
        }
    }

   arr.printResults()

}

fun swap(arr: IntArray,i:Int,j:Int){
    println("i : $i j : $j")
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

fun IntArray.printResults() {
    forEach {
        print("$it ")
    }

    println()
}

