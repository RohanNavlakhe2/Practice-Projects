package programs

fun main() {
  println(maxOperations(intArrayOf(15,15,5,5),20))
  println(maxOperations(intArrayOf(1,2,3,4),5))
  println(maxOperations(intArrayOf(3,1,3,4,3),6))
}

fun maxOperations(nums: IntArray, k: Int): Int {

    val map = HashMap<Int, Int>()
    var count = 0

    nums.forEach {num ->
        if(num <= k){
            val numInMap = map[num]
            if(numInMap != null){
                count++
                if(numInMap > 1){
                     map[num] = numInMap - 1
                }else{
                    map.remove(num)
                }
            }else{
                map[k-num] =  if(map[k-num] == null) 1 else map[k-num]!! + 1
            }
        }
    }

    return count

}