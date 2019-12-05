package aoc2019.day01

import java.io.File

fun main(args: Array<String>) {
    println("day 04 : problem 1")

    //Your puzzle input is 248345-746315.
    var count: Int = 0

    for (i in 248345..746315) {
    //for (i in 248345..256788) {

        //println("checking ${i}")

        //has 6 digits


        //left to right, the digits never decrease; they only ever
        //increase or stay the same

        //two adjacent digits are the same
        if (passAdjacent(i.toString()) && passNeverDecrease(i.toString())) {
            println("found $i")
            count++
        }
        println("------")
        println("")

    }
    println("possible passwords = $count")
}

fun passAdjacent(x: String): Boolean {
    for (i in 1..x.length - 1) {
        val first = x.get(i - 1)
        val second = x.get(i)
        if (first == second) {
            //println("found $x")
            return true
        }
    }
    return false
}

fun passNeverDecrease(x: String): Boolean {
    println("checking $x")
    var ret: Boolean = true
    for (i in 1..x.length - 1) {
        val first = x.get(i - 1).toInt()
        val second = x.get(i).toInt()
        //println("  compare $first to $second")
        if (second < first) {
            ret = false
        }
    }
    return ret
}
