import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.concurrent.thread

class ViewConnection {

    fun findConnection(
        graph: Array<MutableList<Int>>,
        id1: Int,
        id2: Int
    ) {
        
        if (id1 < 0 || id1 >= graph.size) {
            println("Invalid ID.")
            return
        }

        if (id2 < 0 || id2 >= graph.size) {
            println("Invalid ID.")
            return
        }

        if (id1 == id2) {
            println("Person $id1 is the same person.")
            return
        }

        val forwardQueue = ConcurrentLinkedQueue<Int>()
        forwardQueue.add(id1)
        val backwardQueue = ConcurrentLinkedQueue<Int>()
        backwardQueue.add(id2)

        val forwardParents = ConcurrentHashMap<Int, Int>()
        forwardParents[id1] = -1
        val backwardParents = ConcurrentHashMap<Int, Int>()
        backwardParents[id2] = -1

        var meetingNode: Int? = null

        // TODO 8: Create the forward thread


        val forwardThread = thread(start = false, name = "ForwardSearch") {
            while (meetingNode == null && !forwardQueue.isEmpty()) {
                val current = forwardQueue.poll() ?: continue

                if (backwardParents.containsKey(current)) {
                    meetingNode = current
                    break
                }

        // TODO 9: Create the backward thread

        // TODO 10: Start both threads

        // TODO 11: Wait for both threads to finish

        // TODO 12: If meetingNode is null, print that no connection exists

        // TODO 13: If a meetingNode exists, reconstruct the
        //        path from id1 to the meeting node

        // TODO 14: Reconstruct the path from the meeting node to id2

        // TODO 15: Combine the two paths and display the connection
    }
}
