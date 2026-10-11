package com.example.hw02.task1

fun main() {
    // --- Part A: Student Profile ---
    val studentName = "Alya"
    var completedCredits = 20

    // Add 3 credits to the total
    completedCredits += 3
    println("$studentName has completed $completedCredits credits.")

    // --- Part B: Course Meetings ---
    val courseName = "Mobile Application Development"
    var meetingsHeld = 2

    // Record one additional meeting
    meetingsHeld += 1
    println("$courseName has held $meetingsHeld meetings.")
}
