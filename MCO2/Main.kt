fun main() {
    
    print("Enter file path: ")
    val path = readln()
    val fileReader = FileReader()
    val graph = fileReader.readFile(path)

    while (true) {

        println()
        println("1. View person's friends")
        println("2. View connection between two people")
        println("3. Exit")
        print("Choose an option: ")

        when (readln()) {

            "1" -> {
    print("Enter ID of person: ")
    val id = readln().toInt()

    val viewUser = ViewUser()
    viewUser.displayFriendList(graph, id)
}

  "2" -> {
    print("Enter ID number: ")
    val id1 = readln().toInt()

    print("Enter ID number: ")
    val id2 = readln().toInt()

    val viewConnection = ViewConnection()
    viewConnection.findConnection(graph, id1, id2)
}

            "3" -> {
                println("Exiting...")
                break
            }

            else -> {
                println("Invalid option.")
            }
        }
    }
}
