
import java.io.File
import java.util.*


fun main(args: Array<String>) {
    val linesCount = File("/Users/saylikadam/kotlin-workshop/src/main/resources/word-count.txt").readLines()
    getWordCount(linesCount)
    getTheHighestWordCount(linesCount)
    print(getTheHighestWordCount(linesCount))
    print(getWordCount(linesCount))
}

fun getWordCount(lines: List<String>):Int {
    var totalCount = 0
    lines.forEach { line ->
        totalCount += line.split(" ").count()
    }
    return totalCount
}

fun getTheHighestWordCount(lines: List<String>): HashMap<String, Int> {
    val wordCounts = HashMap<String, Int>()
    lines.forEach { line ->
        var wordsInLine = line.split(" ")
        wordsInLine.forEach { word ->

            if ( !wordCounts.containsKey(word)) {
                wordCounts.put(word, 1)
            }
            else {
                wordCounts.put(word, wordCounts[word]!! + 1)
            }
        }
    }
    return wordCounts

}
