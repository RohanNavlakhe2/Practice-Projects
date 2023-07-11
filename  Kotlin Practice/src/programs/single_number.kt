package programs

fun main(){

}

fun singleNumber(nums: IntArray): Int {

   val map = HashMap<Int,Int>()

    nums.forEachIndexed{ index, value ->
        if(map[value] != null){
            map.remove(value)
        }else{
            map[value] = index
        }
    }

    return map.entries.first().key
}