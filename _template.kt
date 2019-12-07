package aoc2019.day01

import java.io.File

val INPUT = "dayX/input.txt"

fun main(args: Array<String>) {
    println("day XX : problem X")

    File("input.txt").forEachLine {

        lineProcessor(it)

    }

}

fun lineProcessor(line: String) {
    println("processing line: ${line}")
}

