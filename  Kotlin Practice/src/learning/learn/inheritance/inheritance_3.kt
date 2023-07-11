package learning.learn.inheritance

fun main() {
    var rohan = Person("ROHAN")
    val android = Android("OnePlus", "")
    val array = arrayOf(android, Ios("Iphone", ""), Tesla("Tesla", "White"), Apple("Apple", "Red"))
    rohan.property = array
    rohan.property.forEach {
        println("${rohan.name} Property : ${it.propertyName}, ${it.speciality}")
        println("android type : ${android::class.java.typeName}")
        when(it) {
            is Tesla -> it.feature()
            is Apple -> it.ui()
            is Android -> it.getRam()
            else -> {
                (it as Ios).getRam()
                it.speciality

            }
        }
    }

}

class Person(val name: String) {
    var property = arrayOf<Property>()
}

abstract class Property(val propertyName: String, val speciality: String) {

}

abstract class Mobile(name: String, speciality: String) : Property(name, speciality) {
    abstract fun getRam()
}

class Android(name: String, speciality: String) : Mobile(name, speciality) {
    override fun getRam() {
    }

}

class Ios(name: String, speciality: String) : Mobile(name, speciality) {
    override fun getRam() {

    }
}

abstract class Car(name: String, speciality: String) : Property(name, speciality) {
    abstract fun colour()
}

class Tesla(name: String, speciality: String) : Car(name, speciality) {
    override fun colour() = println("$propertyName - $speciality")
    fun feature() {

    }
}

class Apple(name: String, speciality: String) : Car(name, speciality) {
    override fun colour() = println("$propertyName - $speciality")
    fun ui() {

    }
}



