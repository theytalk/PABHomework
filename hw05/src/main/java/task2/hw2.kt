package task2

import task1.double
import task1.startsWithVowel

fun applyTwice(n: Int, operation: (Int) -> Int): Int = operation(operation(n))

fun printIf(items: List<String>, condition: (String) -> Boolean) {
    items.filter(condition).forEach { println(it) }
}

fun <T> transform(list: List<T>, mapper: (T) -> String): List<String> = list.map(mapper)

fun main() {
    println(applyTwice(3, double))

    val courses = listOf(
        "Algorithms",
        "Mobile Development",
        "Operating Systems",
        "Database Systems",
        "Information Security"
    )
    printIf(courses, startsWithVowel)

    val squares = transform(listOf(2, 3, 4)) { (it * it).toString() }
    println(squares)
}
