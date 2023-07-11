package learning.learn.visibility_modifiers

fun main() {
    val earth = Earth("Earth")
    earth.printPlanetName()


    val account = BankAccount("Ram", 25, "Hdfc")
    account.enableNetBanking("abc", "12345")
   //account.isNetBankingEnabled = true
}