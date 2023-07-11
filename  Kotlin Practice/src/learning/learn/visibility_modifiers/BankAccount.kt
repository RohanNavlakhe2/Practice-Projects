package learning.learn.visibility_modifiers

class BankAccount(accountHolderName:String,age:Int,bankName:String) {
    private var isNetBankingEnabled = false
    var netBankingUserId:String = ""
    var netBankingPassword:String = ""

    fun enableNetBanking(netBankingUserId:String,netBankingPassword:String){
        isNetBankingEnabled = true
        this.netBankingUserId = netBankingUserId
        this.netBankingPassword = netBankingPassword
        abc()
    }

    private fun abc(){
        isNetBankingEnabled
    }



}

fun main(){
    val ac = BankAccount("A",54,"A")

}