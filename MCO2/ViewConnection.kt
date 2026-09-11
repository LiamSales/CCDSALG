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



val queue: Queue<Int> = LinkedList



        // TODO: Display connection if one exists

        // TODO: Display message if no connection exists
    }
}