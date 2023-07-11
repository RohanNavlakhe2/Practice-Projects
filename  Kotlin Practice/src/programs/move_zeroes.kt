package programs

fun main(){
  moveZeroes(intArrayOf(0,1,0,3,12))
  moveZeroes(intArrayOf(0))
}

fun moveZeroes(nums: IntArray): Unit {
    var i = 0
    var j = -1

    while(i<nums.size && j<nums.size){
        if(nums[i] != 0){
            i++
        }else{

            if(j == -1){
                j = i
            }

            if (nums[j] != 0){
                nums[i] = nums[j]
                nums[j] = 0
            }

            j++
        }
    }

    println(nums.contentToString())
}