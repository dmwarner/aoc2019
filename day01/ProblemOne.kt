package aoc2019.day01

import java.io.File

fun main(args: Array<String>) {
    println("Hello World")

/*
    var sample: Int = 12
    calcFuel(sample)

    sample = 14
    calcFuel(sample)

    sample = 1969
    calcFuel(sample)

    sample = 100756
    calcFuel(sample)
*/

    var runningTotal: Int = 0
    File("input.txt").forEachLine {

        runningTotal = runningTotal + calcFuel(it.toInt())

    }

    println("Total fuel needed = ${runningTotal}")
}

fun calcFuel(mass: Int): Int {
    val fuel: Int = mass.div(3).minus(2)
    println("for mass ${mass}, need ${fuel} fuel")
    return fuel
}
