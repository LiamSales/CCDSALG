import java.io.File

class FileReader {

    fun readFile(path: String): Array<MutableList<Int>> {

        val file = File(path)
        val reader = file.bufferedReader()

        // First line: n e
        val firstLine = reader.readLine().trim().split(Regex("\\s+"))

        val n = firstLine[0].toInt()
        val e = firstLine[1].toInt()

        // graph[id] = list of friends
        val graph = Array(n) { mutableListOf<Int>() }

        // Read every edge
        repeat(e) {

            val line = reader.readLine().trim().split(Regex("\\s+"))

            val a = line[0].toInt()
            val b = line[1].toInt()

            // Bidirectional friendship
            graph[a].add(b)
            graph[b].add(a)
        }

        reader.close()

        return graph
    }
}