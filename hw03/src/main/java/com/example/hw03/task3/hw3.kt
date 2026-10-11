package com.example.hw03.task3

fun testStudent(studentName: String?) {
    // 1. Safe call for length
    println("Length: ${studentName?.length}")

    // 2. Elvis operator for default value
    println("Name: ${studentName ?: "Unknown"}")

    // 3. Safe let block executed only when not null
    studentName?.let {
        println("Hello, $it!")
    }
}

fun main() {
    // Run 1: with studentName = null
    var studentName: String? = null
    testStudent(studentName)

    // Run 2: with studentName = "Ayu"
    studentName = "Ayu"
    testStudent(studentName)
}
