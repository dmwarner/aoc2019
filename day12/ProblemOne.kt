package aoc2019.day12

import java.io.File
import kotlin.math.*

/*
    rm day12/ProblemOne.jar; kotlinc day12/ProblemOne.kt -include-runtime -d day12/ProblemOne.jar; java -jar day12/ProblemOne.jar

    https://adventofcode.com/2019/day/12
*/
fun main(args: Array<String>) {
    println("day12 : problem1")

    val moons: MutableList<Moon> = mutableListOf<Moon>()
    val startVelocity = Triple(0, 0, 0)

/*
EX 1
<x=-1, y=0, z=2>
<x=2, y=-10, z=-7>
<x=4, y=-8, z=8>
<x=3, y=5, z=-1>

EX2
<x=-8, y=-10, z=0>
<x=5, y=5, z=10>
<x=2, y=-7, z=3>
<x=9, y=-8, z=-3>

PUZZLE INPUT
<x=0, y=6, z=1>
<x=4, y=4, z=19>
<x=-11, y=1, z=8>
<x=2, y=19, z=15>
*/
    moons.add(
        Moon(
            Triple(0, 6, 1), startVelocity
        )
    )
    moons.add(
        Moon(
            Triple(4, 4, 19), startVelocity
        )
    )
    moons.add(
        Moon(
            Triple(-11, 1, 8), startVelocity
        )
    )
    moons.add(
        Moon(
            Triple(2, 19, 15), startVelocity
        )
    )

    val time = 1000
    val sim = Simulator(moons, time)


    sim.run()
}

class Simulator(
    val moons: List<Moon>,
    val maxTime: Int
) {

    fun run() {
        println ("Simulator running for $maxTime time steps and ${moons.size} moons")
        for (i in 1 .. maxTime) {
            //update velocity by appling gravity
            for (m in 0..moons.size-2) {
                for (m2 in m+1..moons.size-1) {
                    println("${moons[m].toString()} considered with ${moons[m2].toString()}")
                    var firstModifier = Pair(0, 0) //no change
                    var vmod1 = Triple(0, 0, 0)
                    var vmod2 = Triple(0, 0, 0)
                    //println("comparing X")
                    when ((moons[m].position.first - moons[m2].position.first).sign) {
                        1 -> {
                            //println("greaterthan")
                            vmod1 = Triple(-1, vmod1.second, vmod1.third)
                            vmod2 = Triple(1, vmod2.second, vmod2.third)
                        }
                        0 -> { }//println("equals")
                        -1 -> {
                            //println("lessthan")
                            vmod1 = Triple(1, vmod1.second, vmod1.third)
                            vmod2 = Triple(-1, vmod2.second, vmod2.third)
                        }
                    }

                    //println("comparing Y")
                    when ((moons[m].position.second - moons[m2].position.second).sign) {
                        1 -> {
                            //println("greaterthan")
                            vmod1 = Triple(vmod1.first, -1, vmod1.third)
                            vmod2 = Triple(vmod2.first, 1, vmod2.third)
                        }
                        0 -> { }//println("equals")
                        -1 -> {
                            //println("lessthan")
                            vmod1 = Triple(vmod1.first, 1, vmod1.third)
                            vmod2 = Triple(vmod2.first, -1, vmod2.third)
                        }
                    }

                    //println("comparing Z")
                    when ((moons[m].position.third - moons[m2].position.third).sign) {
                        1 -> {
                            //println("greaterthan")
                            vmod1 = Triple(vmod1.first, vmod1.second, -1)
                            vmod2 = Triple(vmod2.first, vmod2.second, 1)
                        }
                        0 -> { }//println("equals")
                        -1 -> {
                            //println("lessthan")
                            vmod1 = Triple(vmod1.first, vmod1.second, 1)
                            vmod2 = Triple(vmod2.first, vmod2.second, -1)
                        }
                    }
                    moons[m].updateVelocity(vmod1)
                    moons[m2].updateVelocity(vmod2)
                }
            }

            println("After $i time steps")
            //update position by applying velocity
            moons.forEach{
                it.updatePosition()
                println(it)

            }
        } //end time
        var pTotal = 0
        var kTotal = 0
        var total = 0
        moons.forEach {
            total = total.plus(it.totalEnergy())
        }
        println("Energy: $total")
    }
}

class Moon(
    var position: Triple<Int, Int, Int>,    //x, y, z
    var velocity: Triple<Int, Int, Int>

) {

    override fun toString(): String {
        return "$position:$velocity"
    }

    fun totalEnergy(): Int {
        val potential =
            position.first.absoluteValue  + position.second.absoluteValue + position.third.absoluteValue
        val kinetic = velocity.first.absoluteValue + velocity.second.absoluteValue + velocity.third.absoluteValue
        return potential * kinetic
    }
    fun updatePosition() {
        position = Triple(
            position.first + velocity.first,
            position.second + velocity.second,
            position.third + velocity.third
        )
    }

    fun updateVelocity(v: Triple<Int, Int, Int>) {
        println("update velocity $v")
        velocity = Triple(
            velocity.first + v.first,
            velocity.second + v.second,
            velocity.third + v.third
        )
    }
}


