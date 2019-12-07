package aoc2019.day02

import java.io.File

fun main(args: Array<String>) {
    println("running 2019.day2.problem 2")

    var found = false

    File("day02/input.txt").forEachLine {
        //println("line ${it}")

        val ops = it.split(",").toTypedArray().map { it.toInt() }
        println("ops list contains ${ops.size} elements")

        //val noun = 12
        //val verb: Int = 2

        for (noun: Int in 1..100) {
            for (verb: Int in 1..100) {
                val result = runProgram(ops.toMutableList(), noun, verb)
                println("program result: $result for $noun : $verb")
                //if (result == 2641045) {
                if (result == 19690720) {
                    println("FOUND ${(noun*100)+verb}")
                    found = true
                    break

                }
            }
            if (found) { break }
        }
    }

}

fun runProgram(ops: MutableList<Int>, noun: Int, verb: Int): Int {
    ops[1] = noun
    ops[2] = verb

    //println("running program ${ops}")
    for (i in 0..ops.size step 4) {
        //println("${i} operator is ${ops[i]}")
        if (ops[i] == 99) {break}

        //val op1: Int = ops[i+1].toInt()
        //val op2: Int = ops[i+2].toInt()

        when (ops[i]) {
            1 -> {
                ops[ops[i+3]] = (ops[ops[i+1]] + ops[ops[i+2]])

            }
            2 -> {
                ops[ops[i+3]] = (ops[ops[i+1]] * ops[ops[i+2]])
            }
        }
        //println("storing at ")
        //println("result ${println(ops.joinToString(","))}")
    }
    return ops[0]
}

