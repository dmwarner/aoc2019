package aoc2019.day01

import java.io.File

/* orbits map
 * index
 * value
 *      first = parent
 *      second = child
 *      third = depth
 */
//var orbit: Triple<String, String, Int>
var orbits: MutableMap<String, Triple<String, String, Int>> = mutableMapOf()

fun main(args: Array<String>) {
    println("day 06 : problem 1")


    //val dataList = File("day06/input_sample.txt").readLines()
    val dataList = File("day06/input.txt").readLines()

    while (orbits.size < dataList.size + 1) {
        dataList.forEach {
        //File("day06/input.txt").forEachLine {
            lineProcessor(it)
        }
        println("---------")
    }

    println ("mapped ${orbits.size} orbits")
    var count: Int = 0
    orbits.forEach{ _, v ->
        count = count + v.third
    }
    println("total count = ${count}")
    //println (orbits)
}

fun lineProcessor(line: String) {

    val elements: Array<String> = line.split(")").toTypedArray()

    var orbit = Triple(
        elements[0],
        elements[1],
        0
    )
    //println("processing line: ${line}; orbit is ${orbit}; orbits size ${orbits.size}")
    if (orbit.first == "COM") {
        //add COM
        orbits.put(
            "COM",
            Triple("", "", 0)
        )
    }
    //println("first: ${orbit.first} ${orbit.first == "COM"}")

    //if we find the parent add the child to the collection, set depth
    if (orbits.containsKey(orbit.first)) { // && ! (orbit.first == "COM")) {
    println("processing line: ${line}; orbit is ${orbit}; orbits size ${orbits.size}")
        var p = orbits.get(orbit.first)
        orbits.put(
            orbit.second,
            Triple(
                orbit.first,
                "",
                p!!.third.plus(1)
            )
        )
        println("  adding orbit ${orbit.second} ${orbits.get(orbit.second)} to parent ${p}")
        //println("  orbits key: ${orbits.keys}")
        println("  ---")
    }
}

fun lineProcessor_try1(line: String) {
    println("processing line: ${line}")

    val elements: Array<String> = line.split(")").toTypedArray()

    var orbit = Triple(
        elements[0],
        elements[1],
        0
    )

    if (! orbits.containsKey(orbit.first)) {
        println("MISSING PARENT")
        orbits.put(
            orbit.first,
            Triple("", orbit.second, 0)
        )
        var p = orbits.get(orbit.first)
        orbits.put(
            orbit.second,
            Triple(
                orbit.first,
                "",
                p!!.third.plus(1)
            )
        )
    } else {
        println("adding")
        var p = orbits.get(orbit.first)
        orbits.put(
            orbit.second,
            Triple(
                orbit.first,
                "",
                p!!.third.plus(1)
            )
        )
    }
}


