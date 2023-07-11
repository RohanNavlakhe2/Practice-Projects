package learning.learn.polymorphism

fun main() {

    val product2 = Laptop("HP 0254", 25000)

    provideProductPriceAfterDiscount(Mobile("Samsung m52", 18000), 10f)
    provideProductPriceAfterDiscount(product2, 20f)
}

fun provideProductPriceAfterDiscount(product: Product, disc: Float) {
    product.calculatePriceAfterDiscount(disc)
    println("Product Name : ${product.name}")

    if (product is Mobile) {
        product.m1()
    }else if (product is Laptop){
        product.m2()
    }

}

abstract class Product(val name: String, val mrp: Int) {
    abstract fun calculatePriceAfterDiscount(discount: Float)
}

class Mobile(mName: String, mMrp: Int) : Product(mName, mMrp) {
    override fun calculatePriceAfterDiscount(discount: Float) {
        val priceAfterDiscount = mrp - (mrp * discount / 100)
        println("$name price after $discount% is $priceAfterDiscount")
    }

    fun m1() {

    }

}

class Laptop(name: String, mrp: Int) : Product(name, mrp) {
    override fun calculatePriceAfterDiscount(discount: Float) {
        var _discount = discount
        if (mrp < 30000 && _discount > 5) {
            _discount = 5f
        }
        val priceAfterDiscount = mrp - (mrp * _discount / 100)
        println("$name price after $_discount% is $priceAfterDiscount")
    }

    fun m2() {

    }

}