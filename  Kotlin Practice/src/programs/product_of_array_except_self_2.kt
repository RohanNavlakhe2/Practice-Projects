package programs

fun main(){
  println(productExceptSelf2(intArrayOf(1,2,3,4)).contentToString())
  println(productExceptSelf2(intArrayOf(-1,1,0,-3,3)).contentToString())
  println(productExceptSelf2(intArrayOf(1,2,3,0)).contentToString())
  println(productExceptSelf2(intArrayOf(25,30)).contentToString())
}

fun productExceptSelf2(nums: IntArray): IntArray {

    if(nums.size == 2){
        return nums.reversedArray()
    }

    val resultArray = IntArray(nums.size)

    var productFromLeft = 1
    var productFromRight = 1

    resultArray[0] = nums[0]
    resultArray[resultArray.lastIndex] = nums[nums.lastIndex]


    for(i in 0..nums.lastIndex){

        val j = nums.lastIndex - i

        if(i < j){
            if(i!=0 && j!=resultArray.lastIndex){
                resultArray[i] = resultArray[i-1] * nums[i]
                resultArray[j] = resultArray[j+1] * nums[j]
            }
        }else{

            if(i == resultArray.lastIndex){
                resultArray[i] = productFromLeft
            }else{
                resultArray[i] = productFromLeft * resultArray[i+1]
            }

            if(j == 0){
                resultArray[j] = productFromRight
            }else{
                resultArray[j] = productFromRight * resultArray[j-1]
            }
        }

        productFromLeft *= nums[i]
        productFromRight *= nums[j]
    }

    return resultArray
}