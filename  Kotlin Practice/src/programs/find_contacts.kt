package programs

fun main(){

}

fun solution(A: Array<String>, B: Array<String>, P: String): String {

    // write your code in Kotlin 1.3.11 (Linux)

    var contact:String = ""
    var assignedFirstContactFound = false

    for (i in B.indices){
        if(B[i].contains(P)){

            if(!assignedFirstContactFound){
                contact = A[i]
                assignedFirstContactFound = true
            }else if(A[i] < contact){
                contact = A[i]
            }


        }
    }

    return if(contact.isNotEmpty())
        contact
    else
        "NO CONTACT"

}