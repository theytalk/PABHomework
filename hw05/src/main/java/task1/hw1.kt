package task1

val double: (Int) -> Int = { it * 2 }

val startsWithVowel: (String) -> Boolean = { text ->
    text.isNotEmpty() && text.first().lowercaseChar() in "aeiou"
}

val larger: (Int, Int) -> Int = { a, b -> if (a > b) a else b }

fun main() {
    println(double(7))

    println(startsWithVowel("apple"))
    println(startsWithVowel("Banana"))
    println(startsWithVowel("orange"))

    println(larger(12, 7))
}
