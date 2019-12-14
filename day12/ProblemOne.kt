package aoc2019.day12

import java.io.File

/*
rm day12/ProblemOne.jar; kotlinc day12/ProblemOne.kt -include-runtime -d day12/ProblemOne.jar; java -jar day12/ProblemOne.jar
*/

fun main(args: Array<String>) {
    println("day12 : problem1")

    val sample: List<String> = listOf("123456789012")

    sample.forEach {
    //File("input.txt").forEachLine {

        lineProcessor(it)

    }

}

fun lineProcessor(line: String) {
    println("processing line: ${line}")
}

