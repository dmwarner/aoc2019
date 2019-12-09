package aoc2019.day08

import java.io.File
/*
rm day08/ProblemTwo.jar; kotlinc day08/ProblemTwo.kt -include-runtime -d day08/ProblemTwo.jar; java -jar day08/ProblemTwo.jar
*/

val INPUT = "day08/input.txt"

fun main(args: Array<String>) {
    println("day08 : problem02")

    val sample: List<String> = listOf("0222112222120000")

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

    //make the layers
    var shift: Int
    for (i in 0..(line.length/(imgHeight * imgWidth)) - 1) {
        //println("processing layer $i")
        shift = i * (imgWidth * imgHeight)
        layers.add(
            line.substring(shift, shift + (imgWidth * imgHeight))
        )

        //val counts = layers[i].filter { it in "012" }.groupingBy {it}.eachCount()
        println("layer $i  pixels: ${layers[i]}")
    }

    println("rendering")
    var pixelsByLayer: List<Char>
    val layerWidth = layers[0].length

    var columnIdx = 1
    for (i in 0..layerWidth - 1) {
        pixelsByLayer = layers.map { it[i] }
        val displayPixel = choosePixelToDisplay(pixelsByLayer)
        //println("pixels by layer: $pixelsByLayer display: $displayPixel")
        if (columnIdx != imgWidth) {
            print(displayPixel)
            columnIdx++
        } else {
            println(displayPixel)
            columnIdx = 1
        }

    }

    println("-----")
}

fun choosePixelToDisplay(chars: List<Char>): String {
    var result = ""
    for (i in chars.indices) {
        if (chars[i].toString() != "2") {
            result = chars[i].toString()
            break
        }
    }
    if (result == "0") {
        result = " " //for readability
    }
    return result
}
