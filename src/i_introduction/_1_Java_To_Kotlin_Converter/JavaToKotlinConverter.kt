package i_introduction._1_Java_To_Kotlin_Converter

import util.TODO

fun todoTask1(collection: Collection<Int>): Nothing = TODO(
    """
        Task 1.
        Rewrite JavaCode1.task1 in Kotlin.
        In IntelliJ IDEA, you can just copy-paste the code and agree to automatically convert it to Kotlin,
        but only for this task!
    """,
    references = { JavaCode1().task1(collection) })


fun task1(collection: Collection<Int>): String {
    val build= StringBuilder()
    build.append("{")
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        build.append(element)
        if (iterator.hasNext()) {
            build.append(", ")
        }
    }
    build.append("}")
    return build.toString()
}
