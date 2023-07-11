package programs

interface Repository<T> {
    fun get(): Iterable<T>
}

typealias Id = Int


data class Student(val id: Id, val name: String, val subscribedCourses: List<Course>)


data class Course(val id: Id, val name: String, val isPaid: Boolean)

class University(private val repository: Repository<Student>) {
    fun getPaidCoursesWithTheNumbersOfSubscribedStudents(coursesCount: Int): Map<Course, Int> {

        var map = mutableMapOf<Course,Int>()

       val students = repository.get()
        students.forEach { student ->
            student.subscribedCourses.forEach { course ->
                if(course.isPaid){
                    if(map[course] != null){
                          map[course] = map[course]!! + 1
                    }else{
                        map[course] = 1
                    }
                }
            }
        }

        map = map.toSortedMap(Comparator<Course> { o1, o2 -> map[o2]!!.compareTo(map[o1]!!) })

        val resultMap = mutableMapOf<Course,Int>()
        var count = coursesCount

        map.forEach { (t, u) ->

            if(count>0){
                resultMap[t] = u
            }

            count--

        }

        return resultMap
    }

}