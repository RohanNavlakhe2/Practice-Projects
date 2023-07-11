package programs

fun main(){
  removeDuplicates(intArrayOf(1,1,2))
  removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4))
}

fun removeDuplicates(nums: IntArray): Int {
    var i = 1
    var j = 1
    var elementToCheckDuplicate = nums[0]

    while(j < nums.size){
        val currentElement = nums[j]

        if(currentElement != elementToCheckDuplicate){
            nums[i] = currentElement
            i++
            elementToCheckDuplicate = currentElement
        }

        j++
    }

    println("${nums.contentToString()} ${i}")

    return i
}