package aoc2019.day01

import java.io.File

fun main(args: Array<String>) {
    println("2019.day01.p2")

    var fuel4module: Int = 0
    var fuel4fuel: Int = 0

    /*
    var sample: Int = 1969
    fuel4module = calcFuelForModule(sample)

    var fuel4fuel: Int = calcFuelForFuel(fuel4module, 0)
    println("will need additional fuel of ${fuel4module + fuel4fuel}")
    */

    var runningTotal: Int = 0

    File("input.txt").forEachLine {
        fuel4module = calcFuelForModule(it.toInt())
        fuel4fuel = calcFuelForFuel(fuel4module)

        runningTotal = runningTotal + (fuel4module + fuel4fuel)
    }
    println("Total fuel needed = ${runningTotal}")
}

fun calcFuelForModule(mass: Int): Int {
    val fuel4module: Int = mass.div(3).minus(2)
    println("for mass ${mass}, need ${fuel4module} fuel")
    return fuel4module
}

fun calcFuelForFuel(mass: Int): Int {
    if (mass < 1) {
        return 0
    } else {
        var thisFuel: Int = calcFuelForModule(mass)
        if (thisFuel < 1) { thisFuel = 0 }
        return thisFuel + calcFuelForFuel(thisFuel)
    }
}
