package learning.learn

fun calculateTax(amount: Int): Int {
    val oldTaxValue = oldTaxSlab(amount)
    val newTaxValue = newTaxSlab(amount)
    println("Old Tax Value : $oldTaxValue")
    println("New Tax Value : $newTaxValue")
    var diff = 0

    if (oldTaxValue < newTaxValue) {
        println("Old tax value is less")
        diff = newTaxValue - oldTaxValue
    } else if (newTaxValue < oldTaxValue) {
        println("New tax value is less")
        diff = oldTaxValue - newTaxValue
    } else {
        println("Both tax values are same")
    }

    return diff
}

fun oldTaxSlab(amt: Int): Int {
    val tax = amt * 20 / 100
    return tax
}

fun newTaxSlab(amount: Int): Int {
    val tax = amount * 15 / 100
    return tax
}

fun abc(run: Int) {

    if (run == 50) {
        println("fifty")
    }

    if (run >= 50) {
        println("Congrats Fifty : $run")
    }

    val name1 = "Rohan"
    val name2 = "saurabh"

    if (name1 != name2) {

    }
}