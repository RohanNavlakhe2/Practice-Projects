package learning.learn.inheritance


fun main() {
    /*val bankAc = BankAccount("Rohan", 300000f)
    println(bankAc.accountHolderName)
    println(bankAc.currentBalance)
    bankAc.depositAmount(25000)
    bankAc.withdrawAmount(200000)
    bankAc.calculateInterest(10)*/

    val poAc = PostOfficeAccount("Rohan", 50000f)

    println(poAc.accountHolderName)
    println(poAc.currentBalance)

    poAc.depositAmount(20000)
    poAc.withdrawAmount(40000)

    poAc.calculateInterest(6)

    val iciciAccount = IciciAccount("Ram", 50000f)
    iciciAccount.initialFdAmount = 20000
    iciciAccount.calculateFdAmount(7)

    val hdfcAccount = HdfcAccount("Shyam", 250000f)
    hdfcAccount.initialFdAmount = 50000
    hdfcAccount.calculateFdAmount(3)
    hdfcAccount.isNetBankingEnabled = true

    val sbiAccount = SbiAccount("Mohan", 200000f)
    sbiAccount.initialFdAmount = 100000
    sbiAccount.calculateFdAmount(5)

    println("CashWithdrawl Limits")
    iciciAccount.setCashWithdrawlLimit(40000)
    hdfcAccount.setCashWithdrawlLimit(30000)
    sbiAccount.setCashWithdrawlLimit(50000)

}

open class Account(val accountHolderName: String, var currentBalance: Float) {
    fun depositAmount(amount: Int) {
        var temp = currentBalance
        currentBalance += amount
        println("$temp + $amount = $currentBalance")
    }

    fun withdrawAmount(amount: Int) {

        if (currentBalance < amount) {
            println("Failed")
        } else {
            print("$currentBalance - $amount = ")
            currentBalance -= amount
            println(currentBalance)
        }
    }

}

abstract class BankAccount(accountName: String, balance: Float) : Account(accountName, balance) {

    var initialFdAmount = 0
    open var isNetBankingEnabled = false
    abstract val homeLoanInterestRate:Float

    open fun calculateInterest(month: Int) {
        println("$currentBalance x 5% for $month Months ")
        print("Interest Amount = ")
        println((currentBalance * 5 * month) / (100 * 12))
        println("=============================")
    }

    open fun calculateFdAmount(year: Int) {
        val fdAmount = initialFdAmount + initialFdAmount * 5 * year / 100
        println("Fd Amount After $year = $fdAmount")
    }

    abstract fun setCashWithdrawlLimit(amount: Int)
}

class PostOfficeAccount(name: String, amount: Float) : Account(name, amount) {
    fun calculateInterest(month: Int) {
        println("$currentBalance x 7% for $month Months ")
        print("Interest Amount = ")
        println((currentBalance * 7 * month) / (100 * 12))
        println("=============================")
    }
}

class IciciAccount(accountName: String, balance: Float) : BankAccount(accountName, balance) {

    override var isNetBankingEnabled: Boolean = true
    override val homeLoanInterestRate: Float = 8f


    override fun calculateFdAmount(year: Int) {
        val fdAmount = initialFdAmount + initialFdAmount * 7 * year / 100
        println("Fd Amount After $year = $fdAmount")
    }

    override fun setCashWithdrawlLimit(amount: Int) {
        println("ICICI CashWithdrawl Limit : $amount")
    }
}

class HdfcAccount(accountName: String, balance: Float) : BankAccount(accountName, balance) {

    override val homeLoanInterestRate: Float = 7f


    override fun calculateFdAmount(year: Int) {
        super.calculateFdAmount(year)
    }

    override fun setCashWithdrawlLimit(amount: Int) {
        println("HDFC CashWithdrawl Limit : $amount")
    }

}

class SbiAccount(accountName: String, balance: Float) : BankAccount(accountName, balance) {

    override val homeLoanInterestRate: Float = 8.5f

    override fun setCashWithdrawlLimit(amount: Int) {
        println("SBI CashWithdrawl Limit : $amount")
    }
}