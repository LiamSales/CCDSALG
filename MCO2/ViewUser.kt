class ViewUser {

    fun displayFriendList(graph: Array<MutableList<Int>>, id: Int) {

        if (id < 0 || id >= graph.size) {
            println("Invalid ID.")
            return
        }

        val friends = graph[id]

        println("Person $id has ${friends.size} friends!")

        print("List of friends: ")

        for (friend in friends) {
            print("$friend ")
        }

        println()
    }
}