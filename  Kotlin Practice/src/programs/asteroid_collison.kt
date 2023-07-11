package programs

import java.util.*

fun main() {
    println(asteroidCollision(intArrayOf(5,10,-5)).contentToString())
    println(asteroidCollision(intArrayOf(8,-8)).contentToString())
    println(asteroidCollision(intArrayOf(10,2,-5)).contentToString())
    println(asteroidCollision(intArrayOf(-2,1,1,-1)).contentToString())
    println(asteroidCollision(intArrayOf(1,-2,-2,-2)).contentToString())
    println(asteroidCollision(intArrayOf(1,-1,-2,-2)).contentToString())
}

fun asteroidCollision(asteroids: IntArray): IntArray {

    val result = ArrayDeque<Int>()

    for (i in asteroids.indices) {

        val asteroid = asteroids[i]
        val resultTopAsteroid = result.peek() ?: -1

        if (asteroid < 0 && resultTopAsteroid > 0) {

            val asteroidAbs = Math.abs(asteroid)

            while (result.isNotEmpty() && result.peek() > 0 && asteroidAbs > result.peek()){
               result.pop()
            }

            if(result.isNotEmpty() && asteroidAbs == result.peek()){
                result.pop()
                continue
            }

            if(result.peek() ?: 0 > 0){
                continue
            }
        }

        result.push(asteroid)

    }

    return result.toIntArray().reversedArray()

}