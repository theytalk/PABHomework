package com.example.hw03.task5

// Abstract base class
abstract class SmartDevice(val name: String) {
    abstract fun turnOn()

    fun showName() {
        println(name)
    }
}

// Interfaces
interface Connectable {
    fun connect()
}

interface Rechargeable {
    fun charge()
}

// Concrete class implementing multiple interfaces and inheritance
class SmartWatch(name: String) : SmartDevice(name), Connectable, Rechargeable {
    // Private battery property clamped strictly between 0 and 100
    private var battery: Int = 50
        set(value) {
            field = when {
                value < 0 -> 0
                value > 100 -> 100
                else -> value
            }
        }

    var ownerName: String? = null

    override fun turnOn() {
        println("$name is ON")
    }

    override fun connect() {
        println("$name connected to phone")
    }

    override fun charge() {
        battery += 20
        println("Battery: $battery%")
    }

    fun showOwner() {
        println("Owner: ${ownerName ?: "Not set"}")
    }
}

fun main() {
    val watch = SmartWatch("Galaxy Watch")

    watch.showName()
    watch.turnOn()
    watch.connect()

    // Charge three times to demonstrate battery clamping at 100%
    watch.charge()
    watch.charge()
    watch.charge()

    // Show owner before and after setting
    watch.showOwner()
    watch.ownerName = "Rani"
    watch.showOwner()
}
