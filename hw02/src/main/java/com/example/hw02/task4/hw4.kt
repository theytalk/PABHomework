package com.example.hw02.task4

// Function to compute total study minutes
fun calculateStudyMinutes(sessions: Int, minutesPerSession: Int): Int = sessions * minutesPerSession

// Function to compute cumulative credits
fun calculateTotalCredits(courses: Int, creditsPerCourse: Int): Int = courses * creditsPerCourse

fun main() {
    // --- Part A: Calculate Study Minutes ---
    val firstBatch = calculateStudyMinutes(3, 25)
    println("Total study time: $firstBatch minutes")

    val secondBatch = calculateStudyMinutes(4, 30)
    println("Total study time: $secondBatch minutes")

    // --- Part B: Calculate Total Credits per Course Count ---
    val creditsPerCourse = 3
    for (courses in 1..5) {
        val totalCredits = calculateTotalCredits(courses, creditsPerCourse)
        println("Courses: $courses, total credits: $totalCredits")
    }
}
