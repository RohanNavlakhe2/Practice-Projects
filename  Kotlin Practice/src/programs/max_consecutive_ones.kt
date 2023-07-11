package programs

fun main() {
   println(longestOnes(intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1),3))  //10
   println(longestOnes(intArrayOf(1,1,1,0,0,0,1,1,1,1,0),2))  //6
   println(longestOnes(intArrayOf(0,0,1,1,1,0,0),0)) //3
   println(longestOnes(intArrayOf(0,0,0,1),4)) //4
   println(longestOnes(intArrayOf(1,1,1,0,0,0,1,1,1,1),0)) //4
   println(longestOnes(intArrayOf(1,1,1,1,1,0,0,0,0,0),5)) //10
}

fun longestOnes(nums: IntArray, k: Int): Int {

    val listOf0Indices = mutableListOf<Int>()
    var result = 0
    var countOf1 = 0
    var k = k

    if(k == 0){
        nums.forEachIndexed { index, num ->
            if(num == 0){
                countOf1 = 0
            }else{
                countOf1++
                result = Math.max(result,countOf1)
            }
        }

        return result
    }

    nums.forEachIndexed { index, num ->
        if(num == 0){
            listOf0Indices.add(index)
        }
    }

    if(k>listOf0Indices.size){
        k = listOf0Indices.size
    }

    for(index in 0..listOf0Indices.size-k){
        val num = listOf0Indices[index]
        val lastNumInWindow = listOf0Indices[index + k - 1]

        var noOf1 = lastNumInWindow - num + 1


        if(index+k < listOf0Indices.size){
            noOf1 += listOf0Indices[index + k]  - lastNumInWindow - 1
        }else{
            noOf1 += nums.lastIndex - lastNumInWindow
        }

        if(index != 0){
            noOf1 += num - listOf0Indices[index-1] - 1
        }else{
            noOf1 += num
        }

        result = Math.max(result,noOf1)
    }

    return result

}