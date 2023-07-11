package programs

fun main(){
  rotate(intArrayOf(1,2,3,4,5,6,7),3)
  rotate(intArrayOf(-1,-100,3,99),2)
  rotate(intArrayOf(1,2),3)
  rotate(intArrayOf(1,2,3,4,5,6),3)
}

fun rotate(nums: IntArray, k: Int): Unit {

    if(k==0 || k==nums.size || nums.size == 1)
        return

    var savedNo = nums[0]
    var loopCount = 1
    var index = k % nums.size
    var startingIndex = 0

    while(loopCount <= nums.size){

        val temp = nums[index]
        nums[index] = savedNo

        if(index == startingIndex){
            startingIndex = (index + 1) % nums.size
            index += k + 1 % nums.size
            savedNo = nums[startingIndex]
            loopCount++
            continue
        }

        savedNo = temp

        val nextIndex = index + k
        index =  nextIndex % nums.size

        loopCount++
    }

    println(nums.contentToString())

}