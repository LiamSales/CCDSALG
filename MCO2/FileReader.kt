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


// learn "every" command in kotlin

repeat(e) {

    val line = scanner.readLine().split(" ")

    val a = line[0].toInt()
    val b = line[1].toInt()

    graph[a].add(b)
    graph[b].add(a)
}



        scanner.close()

        return graph
    }
}