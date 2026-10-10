package task5

import task3.Student
import task3.students
import kotlin.math.round

fun main() {

    val (passing, failing) = students.partition { it.score >= 70 }
    println("Passing: ${passing.size}   Failing: ${failing.size}")

    students.maxByOrNull { it.score }
        ?.let { println("Top scorer : ${it.name} (${it.score})") }
        ?: println("Top scorer : -")
    students.minByOrNull { it.score }
        ?.let { println("Low scorer : ${it.name} (${it.score})") }
        ?: println("Low scorer : -")

    val total = students.fold(0) { acc, student -> acc + student.score }
    val average = if (students.isEmpty()) 0.0 else round(total.toDouble() / students.size * 10) / 10
    println("Class average: $average")

    val report = buildString {
        appendLine("--- Grade Report ---")
        students.forEach { appendLine(reportLine(it)) }
    }
    print(report)
}

fun reportLine(student: Student): String {
    val status = if (student.score >= 70) "PASS" else "FAIL"
    return "${student.name.padEnd(9)}${student.score.toString().padStart(2)}  $status"
}
