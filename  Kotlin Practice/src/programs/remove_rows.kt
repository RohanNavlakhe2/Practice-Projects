package programs

fun main(){

}

fun solution(S: String): String {

    val rows = S.split("\n")
    var resultStr = rows[0]

    for(i in 1 until rows.size){

        val row = rows[i]
        val cells = row.split(",")

        var isValidRow = true

        for(j in cells.indices){
            val cell = cells[j]
            if(cell == "NULL"){
                isValidRow = false
                break
            }
        }

        if(isValidRow){
            resultStr += "\n"
            resultStr += row
        }

    }

    return resultStr

}

fun solution2(S: String): String {


     val rows = S.split("\n")
     var resultStr = rows[0]

     for(i in 1 until rows.size){
         val row = rows[i]

        /* if(resultStr.isNotEmpty()){
             resultStr += "\n"
         }*/

         if(!row.contains("NULL")){
             /*if(resultStr.isNotEmpty()){
                 resultStr += "\n"
             }*/
             resultStr += "\n"
             resultStr += row

            /* if(i != rows.lastIndex)
                resultStr += "$row\n"
             else
                 resultStr += row*/
         }
     }

    return resultStr

}