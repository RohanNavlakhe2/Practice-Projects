package learning.learn.visibility_modifiers

fun main() {
    val ear = Earth("Mangal")
      //ear.m1()
}

abstract class Planet(private val name: String) {

    open fun printPlanetName() {
        println("My Planet Name Is : ${name.toUpperCase()}")
    }

    protected abstract fun m1()


}

class Earth(name: String) : Planet(name) {
    override fun m1() {

    }


}

