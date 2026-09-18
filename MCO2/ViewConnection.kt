import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.concurrent.thread

class ViewConnection {

    fun findConnection(
        graph: Array<MutableList<Int>>,
        id1: Int,
        id2: Int
    ) {

        // TODO 1: Validate id1 and id2
        if (id1 < 0 || id1 >= graph.size) {
            println("Invalid ID.")
            return
        }

        if (id2 < 0 || id2 >= graph.size) {
            println("Invalid ID.")
            return
        }


        // TODO 2: Handle id1 == id2
        if (id1 == id2) {
            println("Person $id1 is the same person.")
            return
        }


        // TODO 3: Create forwardQueue and add id1
        val forwardQueue = ConcurrentLinkedQueue<Int>()
        forwardQueue.add(id1)


        // TODO 4: Create backwardQueue and add id2
        val backwardQueue = ConcurrentLinkedQueue<Int>()
        backwardQueue.add(id2)


        // TODO 5: Create forwardParents and mark id1 as visited
        val forwardParents = ConcurrentHashMap<Int, Int>()
        forwardParents[id1] = -1


        // TODO 6: Create backwardParents and mark id2 as visited
        val backwardParents = ConcurrentHashMap<Int, Int>()
        backwardParents[id2] = -1


        // TODO 7: Create a shared meetingNode
        var meetingNode: Int? = null


        // TODO 8: Create the forward thread
        val forwardThread = thread(
            start = false,
            name = "ForwardSearch"
        ) {

            while (meetingNode == null && !forwardQueue.isEmpty()) {

                // Get the next node from the queue
                val current = forwardQueue.poll() ?: continue


                // Check if backward search already visited current
                if (backwardParents.containsKey(current)) {
                    meetingNode = current
                    break
                }


                // Explore all neighbors of current
                for (child in graph[current]) {

                    // Cycle detection / visited check
                    if (!forwardParents.containsKey(child)) {

                        // Remember how we reached child
                        forwardParents[child] = current

                        // Put child at the back of the queue
                        forwardQueue.add(child)


                        // Check if backward search has already visited child
                        if (backwardParents.containsKey(child)) {
                            meetingNode = child
                            break
                        }
                    }
                }
            }
        }


        // TODO 9: Create the backward thread
        val backwardThread = thread(
            start = false,
            name = "BackwardSearch"
        ) {

            while (meetingNode == null && !backwardQueue.isEmpty()) {

                // Get the next node from the queue
                val current = backwardQueue.poll() ?: continue


                // Check if forward search already visited current
                if (forwardParents.containsKey(current)) {
                    meetingNode = current
                    break
                }


                // Explore all neighbors of current
                for (child in graph[current]) {

                    // Cycle detection / visited check
                    if (!backwardParents.containsKey(child)) {

                        // Remember how we reached child
                        backwardParents[child] = current

                        // Put child at the back of the queue
                        backwardQueue.add(child)


                        // Check if forward search has already visited child
                        if (forwardParents.containsKey(child)) {
                            meetingNode = child
                            break
                        }
                    }
                }
            }
        }


        // TODO 10: Start both threads
        forwardThread.start()
        backwardThread.start()


        // TODO 11: Wait for both threads to finish
        forwardThread.join()
        backwardThread.join()


        // TODO 12: If meetingNode is null, print that no connection exists
        if (meetingNode == null) {
            println("No connection exists between $id1 and $id2.")
            return
        }


        // ============================================================
        // TODO 13: Reconstruct path from id1 to meetingNode
        // ============================================================

        val forwardPath = mutableListOf<Int>()

        var i = meetingNode

        while (i != id1) {

            // Add current node to the path
            forwardPath.add(i!!)

            // Move backwards using the parent map
            i = forwardParents[i]
        }

        // Add id1, because the loop stops when i reaches id1
        forwardPath.add(id1)

        // Currently the path is backwards:
        //
        // meetingNode -> parent -> parent -> id1
        //
        // Reverse it so it becomes:
        //
        // id1 -> parent -> parent -> meetingNode
        forwardPath.reverse()


        // ============================================================
        // TODO 14: Reconstruct path from meetingNode to id2
        // ============================================================

        val backwardPath = mutableListOf<Int>()

        i = meetingNode

        while (i != id2) {

            // Add current node
            backwardPath.add(i!!)

            // Move toward id2 using backwardParents
            i = backwardParents[i]
        }

        // Add id2
        backwardPath.add(id2)


        // ============================================================
        // TODO 15: Combine the two paths
        // ============================================================

        // forwardPath already contains:
        //
        // id1 -> ... -> meetingNode
        //
        // backwardPath contains:
        //
        // meetingNode -> ... -> id2
        //
        // Remove meetingNode from backwardPath because it
        // already exists at the end of forwardPath.
        backwardPath.removeAt(0)


        val completePath = forwardPath + backwardPath


        // Display the connection
        println("Connection found!")

        print("Path: ")

        for (node in completePath) {
            print("$node ")
        }

        println()
    }
}