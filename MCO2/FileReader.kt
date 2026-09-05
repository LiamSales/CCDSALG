import java.io.File

class FileReader {

    fun readFile(path: String): Array<MutableList<Int>> {

        val file = File(path)
        val scanner = file.bufferedReader()

        // First line: n e
        val firstLine = scanner.readLine().split(" ")

        val n = firstLine[0].toInt()
        val e = firstLine[1].toInt()

        // Create a list for every account
        val graph = Array(n) { mutableListOf<Int>() }

 
// this part needs to be redone manually

// learn "every" command in kotlin

// for second char, add to index+1 of first, but that assumes all ID numbers are natural



        scanner.close()

        return graph
    }
}