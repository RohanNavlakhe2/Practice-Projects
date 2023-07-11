package programs

fun main() {
  println(maxProfit(intArrayOf(7,1,5,3,6,4)))
  println(maxProfit(intArrayOf(7,6,4,3,1)))
}

fun maxProfit(prices: IntArray): Int {

    if(prices.size == 1)
        return 0

    var smallestValue = Int.MAX_VALUE
    var result = Int.MIN_VALUE


    for(i in 1..prices.lastIndex){

        val lastPrice = prices[i-1]

        if(smallestValue > lastPrice){
            smallestValue = lastPrice
        }

        val currentPriceAndSmallestDiff = prices[i] - smallestValue

        if(currentPriceAndSmallestDiff > result){
            result = currentPriceAndSmallestDiff
        }
    }

    return if(result < 0 ) 0 else result
}