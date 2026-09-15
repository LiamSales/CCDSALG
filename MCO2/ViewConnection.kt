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

        val forwardQueue: Queue<Int> = LinkedList()
        val backwardQueue: Queue<Int> = LinkedList()
        val forwardParents = mutableMapOf<Int, Int>()
        val backwardParents = mutableMapOf<Int, Int>()
    
        forwardQueue.add(id1)
        forwardParents[id1] = -1 // -1 signifies the root/start node
    
        backwardQueue.add(id2)
        backwardParents[id2] = -1 // -1 signifies the root/target node


        for (child in id1){
            forwardQueue.add(child)
            forwardParents[child] = id1
        }

        for (child in id2){
            forwardQueue.add(child)
            forwardParents[child] = id2
        }


    
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
