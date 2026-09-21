import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.concurrent.thread

//space and time complexity 

class ViewConnection {

var time: Int = 0
var space: Int = 0

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

        val forwardThread = thread(
            start = false,
            name = "ForwardSearch"
        ) {

            while (meetingNode == null && !forwardQueue.isEmpty()) {

              
                val current = forwardQueue.poll() ?: continue


           
                if (backwardParents.containsKey(current)) {
                    meetingNode = current
                    break
                }


             
                for (child in graph[current]) {

                   
                    if (!forwardParents.containsKey(child)) {

                       
                        forwardParents[child] = current

                        
                        forwardQueue.add(child)


                    
                        if (backwardParents.containsKey(child)) {
                            meetingNode = child
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

            while (meetingNode == null && !backwardQueue.isEmpty()) {

                
                val current = backwardQueue.poll() ?: continue


              
                if (forwardParents.containsKey(current)) {
                    meetingNode = current
                    break
                }


            
                for (child in graph[current]) {

                    
                    if (!backwardParents.containsKey(child)) {

                       
                        backwardParents[child] = current

                       
                        backwardQueue.add(child)


                       
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


    

        val forwardPath = mutableListOf<Int>()

        var i = meetingNode

        while (i != id1) {

           
            forwardPath.add(i!!)

            parent map
            i = forwardParents[i]
        }

      
        forwardPath.add(id1)

       
        forwardPath.reverse()


        
        val backwardPath = mutableListOf<Int>()

        i = meetingNode

        while (i != id2) {

          
            backwardPath.add(i!!)

           
            i = backwardParents[i]
        }

      
        backwardPath.add(id2)


      

  
        backwardPath.removeAt(0)


        val completePath = forwardPath + backwardPath


        
        println("Connection found!")

        print("Path: ")

        for (node in completePath) {
            print("$node ")
        }

        println()
    }
}