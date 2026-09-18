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

        val forwardThread = thread(start = false, name = "ForwardSearch") {

            while (meetingNode == null && !forwardQueue.isEmpty()) {

                val current = forwardQueue.poll() ?: continue
// remove from Q and move to the current var
                
                if (backwardParents.containsKey(current)) {
                    meetingNode = current
                    break
                }

           
                for (child in graph[current]) {

        
                    if (!forwardParents.containsKey(child)) {

//cycle detection 
                        forwardParents[child] = current

//just for mapping,
                        forwardQueue.add(child)

// add all children (full layer) to Q

                        // Check if backward search has already visited child
                        if (backwardParents.containsKey(child)) {
                            meetingNode = child
                            break
                        }
                    }
                }
            }
        }


        val backwardThread = thread(start = false, name = "BackwardSearch") {

            while (meetingNode == null && !backwardQueue.isEmpty()) {

                val current = backwardQueue.poll() ?: continue

                if (forwardParents.containsKey(current)) {
                    meetingNode = current
                    break
                }

                // Explore all neighbors of current
                for (child in graph[current]) {

                    // Only visit child if it has not been visited
                    if (!backwardParents.containsKey(child)) {

                        backwardParents[child] = current
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

        forwardThread.start()
        backwardThread.start()

        forwardThread.join()
        backwardThread.join()
        
        if (meetingNode == null) {
            println("No connection exists between $id1 and $id2.")
            return
        }


        // TODO 13: Reconstruct path from id1 to meetingNode

        // TODO 14: Reconstruct path from meetingNode to id2

        // TODO 15: Combine the two paths and display the connection
    }
}
