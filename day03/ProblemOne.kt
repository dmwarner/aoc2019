package aoc2019.day01

import java.io.File

var allPaths = arrayOf<Array<Int>>()
var allVisitedPoints = listOf<Pair<Int,Int>>()


fun main(args: Array<String>) {
    println("day 3 : problem 1")

    /*
    //initializing allPaths
    for (i in 0..500) {
        var array = arrayOf<Int>()
        for (j in 0..500) {
            array += 0
        }
        allPaths += array
    }

    dumpAllPaths()
    */

    File("input_sample1.txt").forEachLine {

        lineProcessor(it)

    }

}

fun lineProcessor(line: String) {
    println("processing line: ${line}")

    val elements = line.split(",")

    var currentPoint = Pair(0,0)
    elements.forEach{
        val direction: Char = it.first()
        val steps: Int = it.substring(1).toInt()

        currentPoint = getNextPoint(direction, steps, currentPoint)
        println(currentPoint)

    }

}

fun getNextPoint(
        direction: Char,
        steps: Int,
        currentPoint: Pair<Int, Int>
): Pair<Int, Int> {

    var nextPoint = Pair(0, 0)
    when (direction) {
        'U' -> {
            println("moving Up $steps steps")
            nextPoint = Pair(currentPoint.first, currentPoint.second + steps)
        }
        'D' -> {
            println("moving Down $steps steps")
            nextPoint = Pair(currentPoint.first, currentPoint.second - steps)
        }
        'L' -> {
            println("moving Left $steps steps")
            nextPoint = Pair(currentPoint.first - steps, currentPoint.second)
        }
        'R' -> {
            println("moving Right $steps steps")
            nextPoint = Pair(currentPoint.first + steps, currentPoint.second)
        }
    }
    return nextPoint

}

fun dumpAllPaths() {
    for (array in allPaths) {
        for (value in array) {
            print("$value ")
        }
        println()
    }
}
