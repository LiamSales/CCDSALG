class ViewConnection {

    fun findConnection(
        graph: Array<MutableList<Int>>,
        id1: Int,
        id2: Int
    ) {

        // TODO: Check whether id1 is a valid ID

        // TODO: Check whether id2 is a valid ID

        // TODO: If id1 == id2, decide how you want to display
        //       the connection from a person to themselves

        // TODO: Create the data structures needed for
        //       bidirectional BFS

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
