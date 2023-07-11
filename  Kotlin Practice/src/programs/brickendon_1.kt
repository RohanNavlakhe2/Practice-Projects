package programs

fun main(){

}

fun solution2(phone_numbers: Array<String>, phone_owners: Array<String>, number: String): String {
    for(i in phone_numbers.indices){
        val phoneNumber = phone_numbers[i]
        if(phoneNumber == number){
            return phone_owners[i]
        }
    }

    return number
}

fun solution3(A: Array<String>, B: Array<String>, P: String): String {

     var contactPerson = ""

     for(i in B.indices){
         val phoneNumber = B[i]
         if(phoneNumber.contains(P)){
             if(contactPerson.isEmpty){
                 contactPerson = A[i]
             }else if(A[i] < contactPerson){
                 contactPerson = A[i]
             }
         }
     }

    return if(contactPerson.isEmpty()) "NO CONTACT" else contactPerson
}