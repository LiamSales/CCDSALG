import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference
import kotlin.concurrent.thread

class ViewConnection {

    var time: Int = 0
    var space: Int = 0

    fun findConnection(
        graph: Array<MutableList<Int>>,
        id1: Int,
        id2: Int
    ) {

        time = 0
        space = 0

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

        val meetingNode = AtomicReference<Int?>(null)

        val timeCounter = AtomicInteger(0)
        val spaceCounter = AtomicInteger(0)

        val forwardThread = thread(
            start = false,
            name = "ForwardSearch"
        ) {

            while (
                meetingNode.get() == null &&
                !forwardQueue.isEmpty()
            ) {

                val current = forwardQueue.poll() ?: continue

                timeCounter.incrementAndGet()

                if (backwardParents.containsKey(current)) {
                    meetingNode.compareAndSet(null, current)
                    break
                }

                for (child in graph[current]) {

                    timeCounter.incrementAndGet()

                    if (!forwardParents.containsKey(child)) {

                        forwardParents[child] = current

                        forwardQueue.add(child)

                        spaceCounter.incrementAndGet()

                        if (backwardParents.containsKey(child)) {
                            meetingNode.compareAndSet(null, child)
                            break
                        }
                    }
                }
            }
        }

        val backwardThread = thread(
            start = false,
            name = "BackwardSearch"
        ) {

            while (
                meetingNode.get() == null &&
                !backwardQueue.isEmpty()
            ) {

                val current = backwardQueue.poll() ?: continue

                timeCounter.incrementAndGet()

                if (forwardParents.containsKey(current)) {
                    meetingNode.compareAndSet(null, current)
                    break
                }

                for (child in graph[current]) {

                    timeCounter.incrementAndGet()

                    if (!backwardParents.containsKey(child)) {

                        backwardParents[child] = current

                        backwardQueue.add(child)

                        spaceCounter.incrementAndGet()

                        if (forwardParents.containsKey(child)) {
                            meetingNode.compareAndSet(null, child)
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

        time = timeCounter.get()
        space = spaceCounter.get()

        val meeting = meetingNode.get()

        if (meeting == null) {
            println("No connection exists between $id1 and $id2.")
            return
        }

        val forwardPath = mutableListOf<Int>()

        var i = meeting

        while (i != id1) {

            time++

            space++

            forwardPath.add(i)

            i = forwardParents[i]!!
        }

        forwardPath.add(id1)

        forwardPath.reverse()

        val backwardPath = mutableListOf<Int>()

        i = meeting

        while (i != id2) {

            time++

            space++

            backwardPath.add(i)

            i = backwardParents[i]!!
        }

        backwardPath.add(id2)

        backwardPath.removeAt(0)

        val completePath = forwardPath + backwardPath

        time += forwardPath.size + backwardPath.size
        space += forwardPath.size + backwardPath.size

        println("Connection found!")

        print("Path: ")

        for (node in completePath) {
            time++
            print("$node ")
        }

        println()

        println("Time counter: $time")
        println("Space counter: $space")
    }
}