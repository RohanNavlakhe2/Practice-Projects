
//QA-2

fun main(){

    val arr = arrayOf(2,2,3,4,5,5)
    checkIfIncreasing(arr,arr.size)

    val arr2 = arrayOf(2,2,3,4,4,5,5)
    checkIfIncreasing(arr2,arr2.size)

    val arr3 = arrayOf(50,60,60,70,80)
    checkIfIncreasing(arr3,arr3.size)
}

fun checkIfIncreasing(arr:Array<Int>,length:Int){
    var isIncreasing = false

    for(i in 0 until length-1){
        for(j in i+1 until length){
            var value:Int? =null

            for(k in arr.indices){
                if(k!=i && k!=j){
                    if(value == null){
                        value = arr[k]
                        isIncreasing = true
                    }else if(arr[k] > value){
                        value = arr[k]
                        isIncreasing = true
                    }else{
                        isIncreasing = false
                    }
                }
            }

        }
    }

    if(isIncreasing){
        println("YES")
    }else
        println("NO")
}