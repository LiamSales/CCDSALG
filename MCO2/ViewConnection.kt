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

if (id1 == id2) return


        // TODO: Display connection if one exists

        // TODO: Display message if no connection exists
    }



fun bidirectionalBfs(start: Node, target: Node): Int {


    // Queues for traversing levels
    val queueStart = ArrayDeque<Node>().apply { add(start) }
    val queueTarget = ArrayDeque<Node>().apply { add(target) }

    // Visited sets with distance tracking
    val visitedStart = mutableMapOf(start to 0)
    val visitedTarget = mutableMapOf(target to 0)

    while (queueStart.isNotEmpty() && queueTarget.isNotEmpty()) {
        // Expand from the start side
        val distFromStart = expandLevel(queueStart, visitedStart, visitedTarget)
        if (distFromStart != -1) return distFromStart

        // Expand from the target side
        val distFromTarget = expandLevel(queueTarget, visitedTarget, visitedStart)
        if (distFromTarget != -1) return distFromTarget
    }

    return -1 // No path found
}

private fun expandLevel(
    queue: ArrayDeque<Node>,
    visitedThisSide: MutableMap<Node, Int>,
    visitedThatSide: Map<Node, Int>
): Int {
    val size = queue.size
    for (i in 0 until size) {
        val current = queue.removeFirst()
        val currentDist = visitedThisSide[current]!!

        for (neighbor in current.neighbors) {
            // If the other search already visited this neighbor, we met!
            if (visitedThatSide.containsKey(neighbor)) {
                return currentDist + visitedThatSide[neighbor]!! + 1
            }

            if (!visitedThisSide.containsKey(neighbor)) {
                visitedThisSide[neighbor] = currentDist + 1
                queue.add(neighbor)
            }
        }
    }
    return -1
}



}