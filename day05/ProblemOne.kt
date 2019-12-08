package aoc2019.day05

import java.io.File

/*
rm day05/ProblemOne.jar; kotlinc day05/ProblemOne.kt -include-runtime -d day05/ProblemOne.jar; java -jar day05/ProblemOne.jar
*/

fun main(args: Array<String>) {
    println("running 2019.day5.problem1")

    var found = false


    File("day02/input.txt").forEachLine {
        //println("line ${it}")

        val ops = it.split(",").toTypedArray().map { it.toInt() }
        println("ops list contains ${ops.size} elements")

        //val noun = 12
        //val verb: Int = 2

        val icc = IntCodeComputer(ops.toMutableList())


        for (noun: Int in 1..8) {
            for (verb: Int in 1..8) {
        //        val result = runProgram(ops.toMutableList(), noun, verb)
                val result = icc.runProgram(noun, verb)
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
class IntCodeComputer(var program: MutableList<Int>) {


    fun runProgram(noun: Int, verb: Int): Int {
        program[1] = noun
        program[2] = verb

        //println("running program ${program}")
        for (i in 0..program.size step 4) {
            if (program[i] == 99) {break}

            when (program[i]) {
                1 -> {
                    program = op1(program, i+1, i+2, i+3)
                }
                2 -> {
                    program = op1(program, i+1, i+2, i+3)
                }
            }
        }
        return program[0]
    }

    //add
    fun op1(
        source: MutableList<Int>,
        x: Int,
        y: Int,
        loc: Int
    ): MutableList<Int> {
        source[loc] = source[x] + source[y]
        return source
    }

    //multiply
    fun op2(
        source: MutableList<Int>,
        x: Int,
        y: Int,
        loc: Int
    ): MutableList<Int> {
        source[loc] = source[x] * source[y]
        return source
    }

    //save
    fun op3(
        source: MutableList<Int>,
        v: Int,
        loc: Int
    ): MutableList<Int> {
        source[loc] = v
        return source
    }

    //get
    fun op4(
        source: List<Int>,
        loc: Int
    ): Int {
        return source[loc]
    }
}

