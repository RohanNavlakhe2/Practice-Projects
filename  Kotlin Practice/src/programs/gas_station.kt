package programs

fun main(){
   println(canCompleteCircuit(intArrayOf(1,2,3,4,5), intArrayOf(3,4,5,1,2)))
   println(canCompleteCircuit(intArrayOf(2,3,4), intArrayOf(3,4,3)))
   println(canCompleteCircuit(intArrayOf(1,2,3,3), intArrayOf(2,1,5,1)))
    val arr = intArrayOf(
        67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66
    )

    val arr2 = intArrayOf(
        27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26
    )
   println(canCompleteCircuit(arr, arr2))
}

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

    var availableGas = 0
    var startIndex = -1
    var totalGas = 0
    var totalCost = 0

    for(i in gas.indices){

        val currentGas = gas[i]
        val currentCost = cost[i]

        availableGas += currentGas

        if(availableGas - currentCost >= 0){
            if(startIndex == -1){
                startIndex = i
            }
            availableGas -= currentCost
        }else{
            startIndex = -1
            availableGas = 0
        }

        totalGas += currentGas
        totalCost += currentCost
    }

    return if(totalGas - totalCost < 0) -1 else startIndex
}