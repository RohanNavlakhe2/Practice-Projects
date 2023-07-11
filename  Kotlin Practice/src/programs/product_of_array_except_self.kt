package programs

fun main(){
  println(productExceptSelf(intArrayOf(1,2,3,4)).contentToString())
  println(productExceptSelf(intArrayOf(-1,1,0,-3,3)).contentToString())
}

fun productExceptSelf(nums: IntArray): IntArray {

    if(nums.size == 2){
        return nums.reversedArray()
    }

    val resultArray = IntArray(nums.size)
    resultArray[0] = nums[0]
    resultArray[resultArray.lastIndex] = nums[nums.lastIndex]


    for(i in 1..nums.lastIndex){

        val j = nums.lastIndex - i

        if(i < j && i != 0 && j != nums.lastIndex){
            resultArray[i] = resultArray[i-1] * nums[i]
            resultArray[j] = resultArray[j+1] * nums[j]
        }else{
            if(i-j == 0 || i-j == 1){
                resultArray[j] = resultArray[j-1] * resultArray[j+1]
            }else{
                val divideBy = if(nums[j] == 0) 1 else nums[j]
                resultArray[j] = (resultArray[j+1]*nums[j+1])/divideBy

            }

            if(i!=j){
                val divideBy = if(nums[i] == 0) 1 else nums[i]
                resultArray[i] = (resultArray[i-1]*nums[i-1])/divideBy
            }


        }
    }

    return resultArray
}