package task3

data class Student(val name: String, val score: Int, val year: Int)

val students = listOf(
    Student("Ali",   85, 2023),
    Student("Budi",  62, 2022),
    Student("Citra", 91, 2023),
    Student("Dewi",  58, 2022),
    Student("Eka",   76, 2023)
)

fun main() {

    val passing = students.filter { it.score >= 70 }
    println("Students dengan score>= 70: ${passing.size}")

    students
        .map { "${it.name} (${it.score})" }
        .forEach { println(it) }

    val topThree = students
        .sortedByDescending { it.score }
        .take(3)
        .map { it.name }
    println("Top 3: $topThree")

    val total = students.fold(0) { acc, student -> acc + student.score }
    val average = total.toDouble() / students.size
    println("Total: $total   Average: $average")

    students
        .groupBy { it.year }
        .forEach { (year, group) -> println("$year: ${group.map { it.name }}") }
}
