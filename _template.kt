package aoc2019.day01

import java.io.File

fun main(args: Array<String>) {
    println("day XX : problem X")

    File("input.txt").forEachLine {

        lineProcessor(it)

    }

}

fun lineProcessor(String: line): <T> {
    println("processing line: ${it}")
}

