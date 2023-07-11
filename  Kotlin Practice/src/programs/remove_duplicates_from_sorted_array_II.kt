package programs

fun main(){
  removeDuplicatesII(intArrayOf(1,1,1,2,2,3))
  removeDuplicatesII(intArrayOf(0,0,1,1,1,1,2,3,3))
}

fun removeDuplicatesII(nums: IntArray): Int {

    var i = 1
    var j = 1
    var elementToCheckDuplicate = nums[0]
    var elementTocheckDuplicateCount = 1

    while (j < nums.size){

        val currentElement = nums[j]
        if(currentElement == elementToCheckDuplicate){
            elementTocheckDuplicateCount++
            if(elementTocheckDuplicateCount  == 2){
                nums[i] = currentElement
                i++
            }
        }else{
            elementToCheckDuplicate = currentElement
            elementTocheckDuplicateCount = 1
            nums[i] = currentElement
            i++
        }

        j++

    }

    println("${nums.contentToString()} $i")

    return i
}