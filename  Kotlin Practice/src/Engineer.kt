abstract class Engineer {

    abstract var field: String

    fun work() = "engineering"
}

class MechanicalEngineer : Engineer() {
    override var field: String = "ME"
}

fun main() {
    val e = MechanicalEngineer()

}

