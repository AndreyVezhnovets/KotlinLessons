package ii_collections

import ii_collections.data.orderedProducts

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products ordered by customer
   // todoCollectionTask()
    return orders.flatMap { it.products }.toSet()

}

val Shop.allOrderedProducts: Set<Product> get() {
    //   return orderedProducts
  return customers.flatMap { it.orderedProducts }.toSet()

}


/*
fun main(a: Array<String>){

    val a:MutableList<String> = mutableListOf("абв","где","123")
    a.add("15")
    a.add("жзи")
print(a.map { it+1 }).toString()
    println()
  val c=  a.flatMap { it.map { it+6 } }.toString()
    print(c)

}*/