package programs

fun main(){
   println(maxProfit3(intArrayOf(7,1,5,3,6,4)))
   println(maxProfit3(intArrayOf(1,2,3,4,5)))
   println(maxProfit3(intArrayOf(7,6,4,3,1)))
}

fun maxProfit3(prices: IntArray): Int {

    var profit = 0
    var nextDayPrice = prices.last()

    for(i in prices.lastIndex -1 downTo 0){

        val currentDayPrice = prices[i]

        if(currentDayPrice < nextDayPrice){
            profit += nextDayPrice - currentDayPrice
        }

        nextDayPrice = currentDayPrice
    }

    return profit
}