package learning.practice

import kotlin.system.exitProcess

var recentContactList = mutableMapOf<String, String>()
var contactList = mutableMapOf<String, String>()
var contactNumber = ""

fun main() {

    interFace()

}


fun interFace() {
    while (true) {
        println("(Phone Application Interface)")
        println("1) Keypad")
        println("2) Contacts")
        println("3) Recents")
        println("4) Exit")
        user()
    }
}

fun user() {
    var input = readLine()!!.toInt()

    when (input) {
        1 -> keypad()
        2 -> contacts()
        3 -> recents()
        4 -> exitProcess(0)
    }

}

fun keypad() {
    println("Dial \"10 digit\" Mobile Number")
    contactNumber = readLine()!!
    if (contactList.containsKey(contactNumber) && contactList[contactNumber] != "Unknown Number") {
        println(contactList[contactNumber])
        println("1) Call")
        println("2) Update Existing Contacts")
    } else {
        println("1) Call")
        println("2) Add To Contacts")
    }


    var input = readLine()!!.toInt()
    when (input) {
        1 -> call()
        2 -> {
            if (contactList.containsKey(contactNumber)) {
                updateContactList()
            } else {
                addToContacts()
            }
        }
    }
}

fun call() {
    if (!contactList.containsKey(contactNumber)) {
        contactList[contactNumber] = "Unknown Number"
        println("Calling\n${contactList[contactNumber]}\n$contactNumber")
        recentContactList[contactNumber] = contactList[contactNumber]!!
    } else {
        println("Calling\n${contactList[contactNumber]}\n$contactNumber")
        recentContactList[contactNumber] = contactList[contactNumber]!!
    }

}


fun addToContacts() {
    println("Create New Contact")
    println("Name:-")
    var contactName = readLine()!!
    contactList[contactNumber] = contactName
    println("Contact Saved")


}

fun updateContactList() {
    println("Edit Contact Name")
    var contactName = readLine()!!
    contactList[contactNumber] = contactName
    println("Contact Successfully Updated")
}

fun contacts() {
    if (contactList.isEmpty()) {
        println("Contact List Is Empty")
        return
    }
    (contactList.forEach {
        println("${it.value}\n${it.key}")
    })
    println("1) Select a number for \"MORE ACTION\" if you want")
    println("2) Back")
    var input = readLine()!!.toInt()
    when (input) {
        1 -> moreAction()
        2 -> return

    }
}


fun moreAction() {
    contactNumber = readLine()!!
    println("1) Call")
    println("2) Edit")
    println("3) Cancel")
    var input = readLine()!!.toInt()
    when (input) {
        1 -> call()
        2 -> updateContactList()
        3 -> return
    }
}

fun recents() {
    if (recentContactList.isEmpty()) {
        println("No Recent Calls")
    } else {
        recentContactList.forEach {
            println("${it.value}\n${it.key}")
        }
    }

}

































