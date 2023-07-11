data class Product(val productName:String) {

    var price:Int = 0

    constructor(productName: String,price:Int) : this(productName) {
        this.price = price
    }
}