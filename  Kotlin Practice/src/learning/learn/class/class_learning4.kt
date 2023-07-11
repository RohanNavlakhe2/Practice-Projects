package learning.learn.`class`

fun main(){
    val teacher1 = Teacher("Rahul","Maths",25)

    val teacher2 = Teacher("Rahul","Maths",30)

    val teacher3 = teacher1
    teacher3.age = 35

    println("Teacher 1 : $teacher1, Age : ${teacher1.age}")
    println("Teacher 2 : $teacher2, Age : ${teacher2.age}")
    println("Teacher 3 : $teacher3, Age : ${teacher3.age}")

    println("are teacher1 and teacher2 contain same data? ${teacher1 == teacher2}")
    println("are teacher1 and teacher2 same objects? ${teacher1 === teacher2}")
    println("are teacher1 and teacher3 same objects? ${teacher1 === teacher3}")
}

data class Teacher(val name:String,val subject:String,var age:Int){

}