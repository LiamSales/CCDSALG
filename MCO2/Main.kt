fun main() {

    // Ask for dataset path
    print("Enter file path: ")
    val path = readLine()!!

    // Read and build graph
    val fileReader = FileReader()
    val graph = fileReader.readFile(path)

    // Main menu
    while (true) {

        println()
        println("1. View person's friends")
        println("2. View connection between two people")
        println("3. Exit")
        print("Choose an option: ")

        when (readLine()) {

            "1" -> {
                // TODO: Implement friend list
            }

            "2" -> {
                // TODO: Implement connection/path
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