package learning.learn.`class`

val studentList = mutableListOf<Student>()

fun main() {
    addStudents()
    takeStudentMarks()
    showStudents()
}

fun addStudents() {
    for (i in 1..2) {

        println("Enter Student Roll No")
        val rollNo = readLine()!!.toInt()

        println("Enter Student Name")
        val name = readLine()!!

        println("Enter Student Class Name")
        val className = readLine()!!

        println("Enter Student Age")
        val age = readLine()!!.toInt()

        val student = Student(rollNo, name, className, age)

        studentList.add(student)
    }
    println(studentList)
}

fun takeStudentMarks() {
    studentList.forEach { student ->
        println("Enter Marks For ${student.name} ")
        student.marksMap.forEach {
            print("${it.key} : ")
            val marks = readLine()!!.toInt()
            student.marksMap[it.key] = marks
            println()
        }
    }
}

fun showStudents() {
    studentList.forEach { student ->
        println("===========")
        println(student)
        student.marksMap.forEach {
            println("${it.key}  : ${it.value}")
        }
        println("Total Marks : ${student.marksMap.values.sum()}")
        println("Percentage : ${student.percentage()}")
        println("Grade : ${student.grade()}")
        println("===========")
    }
}

data class Student(var rollNo: Int, var name: String, var className: String, var age: Int) {
    val marksMap = mutableMapOf<String, Int>("Maths" to 0, "Hindi" to 0, "Sanskrut" to 0)


    fun percentage(): Float {
        val totalMarks = marksMap.values.sum().toFloat()
        val percentage = ((totalMarks * 100) / (marksMap.size * 100))
        return percentage
    }

    fun grade():String {
        val per = percentage()
        var result = when (per) {
            in 0f..35f -> "FAIL"
            in 36f..60f -> "B"
            in 61f..100f -> "A"
            else -> "error"
        }
         return result
    }

}












