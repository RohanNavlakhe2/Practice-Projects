package learning.learn.has_a


fun main() {
    val personRam = Person("Ram")
    personRam.bike = Bike("Apache", "RTR")
    personRam.mobile = Mobile("Samsung", 35000, "Dynamic")
    personRam.bike?.getAverage()
    println("Ram's Bike : ${personRam.bike?.name} & Model is ${personRam.bike?.model}")
    println(personRam.mobile?.price)
    println(personRam.mobile?.s)
    println(personRam.mobile?.display())


    val personShyam = Person("Shyam")
    personShyam.bike = Bike("Pulsar", "NS20")
    personShyam.mobile = Mobile("Apple", 75000, "Amoled")
    personShyam.bike?.getAverage()
    println("Shyam's Bike : ${personShyam.bike?.name}")

    val personMohan = Person("Mohan")
    println("Mohan's Bike : ${personMohan.bike?.name}")


}

class Person(val name: String) {
    var bike: Bike? = Bike("Bajaj", "CT100")
    var mobile: Mobile? = null
}

class Bike(val name: String, val model: String) {
    fun getAverage() {
        if (name == "Apache") {
            println("Apache Average : 40")
        } else if (name == "Pulsar") {
            println("Pulsar Average : 45")
        }
    }
}

class Mobile(val name: String, val price: Int, display: String) {
    val s = "$name phone's $display Display is Good"
    fun display() {

    }

}