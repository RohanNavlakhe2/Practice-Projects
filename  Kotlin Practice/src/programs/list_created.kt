package programs

import kotlin.system.exitProcess

val studentList = mutableListOf<String>()

fun main() {
    givenOptions()

}

fun givenOptions() {
    while (true) {
        println("Enter - 1 for <<< Add Student >>>")
        println("Enter - 2 for <<< View Students >>>")
        println("Enter - 3 for <<< Update Students >>>")
        println("Enter - 4 for <<< Delete Students >>>")
        println("Enter - 5 for <<< Exit >>>")
        getInput()

    }

}

fun getInput() {

    var optionSelected = readLine()?.toInt()

    when (optionSelected) {
        1 -> addStudent()
        2 -> viewStudents()
        3 -> updateStudent()
        4 -> deleteStudent()
        5 -> exitProcess(0)
        else -> {
            println("Enter Valid Input Number Of Any, Given Same As Like This - 1,2,3,4")
        }
    }

}

fun addStudent() {
    println("Enter Student Name Or \"Ok\" to Save List")
    while (true) {
        val userInput = readLine()!!
        if (userInput == "Ok") {
            return
        }
        studentList.add(userInput)
    }

}


fun viewStudents() {
    studentList.forEachIndexed { index, value ->
        println("${index+1} - $value")

    }

}


fun updateStudent() {
    println("Required Student Name For Replace")
    viewStudents()
    var update = readLine()
    var indexNumber = studentList.indexOf(update)
    if (indexNumber == -1) {
        println("Student Not Exist - Try Again")
        updateStudent()
    } else {
        println("Required Student Name For Update")
        studentList[indexNumber] = readLine()!!

        viewStudents()
    }


}


fun deleteStudent() {
    println("Required Student Name For Delete")
    viewStudents()
    var delete = readLine()
    var elementRemove = studentList.remove(delete)
    if (!elementRemove) {
        println("Student Not Exist - Try Again")
        deleteStudent()
    } else {
        println("Delete Successful")
        viewStudents()
    }
}


