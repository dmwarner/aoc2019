package aoc2019.day01

import java.io.File

val INPUT = "dayXX/input.txt"

fun main(args: Array<String>) {
    println("dayXX : problemdX")

    val sample: List<String> = listOf("123456789012")

    //sample.forEach {
    File("input.txt").forEachLine {

        lineProcessor(it)

    }

}

fun lineProcessor(line: String) {
    println("processing line: ${line}")
}

