package ii_collections

import ii_collections.data.customers

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    return customers.maxBy { it.orders.size }
    // todoCollectionTask()
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    // Return the most expensive product which has been ordered
   // todoCollectionTask()
    return orders.flatMap { it.products}.toSet().maxBy { it.price }
}
