package aoc2019.day08

import java.io.File
/*
rm day08/ProblemOne.jar; kotlinc day08/ProblemOne.kt -include-runtime -d day08/ProblemOne.jar; java -jar day08/ProblemOne.jar
*/

val INPUT = "day08/input.txt"

fun main(args: Array<String>) {
    println("day08 : problem01")

    val sample: List<String> = listOf("123456789012")

    //sample.forEach {
    File(INPUT).forEachLine {

        lineProcessor(it)

    }

}

fun lineProcessor(line: String) {
    //println("processing line: ${line}")
    val imgHeight: Int = 6
    val imgWidth: Int = 25
    val layers: MutableList<String> = mutableListOf<String>()


    //layers
    var shift: Int
    for (i in 0..imgHeight - 1) {
        shift = i * (imgWidth * imgHeight)
        layers.add(
            line.substring(shift, shift + (imgWidth * imgHeight))
        )

        val counts = layers[i].filter { it in "012" }.groupingBy {it}.eachCount()
        println("layer $i  pixels: ${layers[i]}  counts: $counts")
    }

    val tst = "00012224101211"
    //val cnt = tst.count { tst.contains("0") }
    val cnt = tst.filter { it in "012" }.groupingBy {it}.eachCount()
    println(cnt)

    println("-----")
}

