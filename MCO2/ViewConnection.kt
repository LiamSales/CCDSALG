import java.util.LinkedList
import java.util.Queue

class ViewConnection {

    fun findConnection(
        graph: Array<MutableList<Int>>,
        id1: Int,
        id2: Int
    ) {

        if (id1 < 0 || id1 >= graph.size ||
id2 < 0 || id2 >= graph.size ) {
            println("Invalid ID.")
            return
        }

if (start == target) return 0

val queueStart = ArrayDeque<Node>().apply { add(start) }
    val queueTarget = ArrayDeque<Node>().apply { add(target) }

    // Visited sets with distance tracking
    val visitedStart = mutableMapOf(start to 0)
    val visitedTarget = mutableMapOf(target to 0)






        // TODO: Display connection if one exists

        // TODO: Display message if no connection exists
    }
}