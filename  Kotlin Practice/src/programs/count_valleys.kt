package programs

fun main(){
  println("Valleys : "+ countingValleys(8,"UDDDUDUUDU"))
}

fun countingValleys(steps: Int, path: String): Int {

    var position = 0
    var valleyCount = 0

    path.forEachIndexed { index, c ->

        val prevPosition = position

        if(c == 'U')
            position+=1
        else
            position-=1

        if(position == 0 && prevPosition < 0)
            valleyCount+=1
    }

    return valleyCount
}
