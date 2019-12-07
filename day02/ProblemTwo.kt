package aoc2019.day02

import java.io.File

fun main(args: Array<String>) {
    println("running 2019.day2.problem1")


    File("input.txt").forEachLine {
        println("line ${it}")

        //val ops = it.split(",")
        val ops = it.split(",").toTypedArray()
        println("ops list contains ${ops.size} elements")

        ops[1] = "12"
        ops[2] = "2"


        for (i in 0..ops.size step 4) {
            println("${i} operator is ${ops[i]}")
            if (ops[i].toInt() == 99) {break}

            //val op1: Int = ops[i+1].toInt()
            //val op2: Int = ops[i+2].toInt()

            when (ops[i].toInt()) {
                1 -> {
                    ops[ops[i+3].toInt()] = (ops[ops[i+1].toInt()].toInt() + ops[ops[i+2].toInt()].toInt()).toString()

                }
                2 -> {
                    ops[ops[i+3].toInt()] = (ops[ops[i+1].toInt()].toInt() * ops[ops[i+2].toInt()].toInt()).toString()
                }
            }
            println("storing at ")
            println("result ${println(ops.joinToString(","))}")
        }

    }


    //println("ops list contains ${ops.size} elements")
}

fun calcFuel(mass: Int): Int {
    val fuel: Int = mass.div(3).minus(2)
    println("for mass ${mass}, need ${fuel} fuel")
    return fuel
}
