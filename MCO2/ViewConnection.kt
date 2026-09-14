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

        // TODO: Create the data structures needed for
        //       bidirectional BFS

        val forwardQueue: Queue<Int> = LinkedList()
        val backwardQueue: Queue<Int> = LinkedList()

        

        //Two Parent Maps to track visited nodes and reconstruct the path
        // Using Map instead of Set because key presence proves it was visited, 
        // and the value stores the parent pointer.
        val forwardParents = mutableMapOf<Int, Int>()
        val backwardParents = mutableMapOf<Int, Int>()
    
        // Initialize structures
        forwardQueue.add(id1)
        forwardParents[id1] = -1 // -1 signifies the root/start node
    
        backwardQueue.add(id2)
        backwardParents[id2] = -1 // -1 signifies the root/target node


        

        // TODO: Start one search from id1

        // TODO: Start the other search from id2

        // TODO: Repeatedly expand the searches level by level

        // TODO: When a node reached by the id1 search
        //       has already been reached by the id2 search,
        //       the searches have met

        // TODO: Keep enough information to reconstruct
        //       the actual path from id1 to id2

        // TODO: If the searches meet, reconstruct and display
        //       the connection

        // TODO: If both searches finish without meeting,
        //       report that no connection exists
    }


    // TODO: Implement the bidirectional BFS here
    //
    // TODO: The search should receive the graph,
    //       starting ID, and target ID
    //
    // TODO: Create one queue for the id1 side
    //
    // TODO: Create one queue for the id2 side
    //
    // TODO: Create visited information for each side
    //
    // TODO: Expand the searches level by level
    //
    // TODO: Detect when the two searches meet
    //
    // TODO: Return enough information to reconstruct
    //       the path, not just the distance
}
