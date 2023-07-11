package learning.learn.`class`

fun main(){
   val product = Product(1,"Samsung Galaxy A35",25000)
    product.color = "Black"
    println("Product : $product , Color : ${product.color}")
    updateProduct(product.copy())
    println("Product : $product , Color : ${product.color}")
}

fun updateProduct(product:Product){
    product.price = 22000
    //product.color = "Red"
    println("Update Product : $product , Color : ${product.color}")
}


data class Product(val productId:Int,var productName:String,var price:Int){
    var color:String = ""
}