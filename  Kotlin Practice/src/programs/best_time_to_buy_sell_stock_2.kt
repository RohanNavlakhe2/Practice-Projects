package programs

fun main(){
   println(maxProfit2(intArrayOf(7,1,5,3,6,4)))
   println(maxProfit2(intArrayOf(1,2,3,4,5)))
   println(maxProfit2(intArrayOf(7,6,4,3,1)))
}

fun maxProfit2(prices: IntArray): Int {

    var profit = 0

    for(i in prices.lastIndex -1 downTo 0){

        val currentDayPrice = prices[i]
        val nextDayPrice = prices[i+1]

        if(currentDayPrice < nextDayPrice){
            profit += nextDayPrice - currentDayPrice
        }
    }

    return profit
}