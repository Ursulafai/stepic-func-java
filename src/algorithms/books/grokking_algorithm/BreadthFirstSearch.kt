package algorithms.books.grokking_algorithm

import java.util.LinkedList
import java.util.Queue

class BreadthFirstSearch {
    private val allConnections = HashMap<String, ArrayList<String>>()

    init {
        allConnections["tanya"] = arrayListOf("bob", "alice", "claire")
        allConnections["bob"] = arrayListOf("anuj", "peggy")
        allConnections["alice"] = arrayListOf("peggy")
        allConnections["claire"] = arrayListOf("tom", "jonny")
    }

    fun breadthSearch(nameToSearch: String): Boolean {
        val workingQueue: Queue<String> = LinkedList()
        val checkedElements = LinkedList<String>()

        workingQueue.add("tanya")

        while (!workingQueue.isEmpty()) {
            val candidate = workingQueue.peek()

            if (nameToSearch == candidate) {
                return true
            }

            allConnections[candidate]?.forEach {
                if (!checkedElements.contains(it))
                    workingQueue.add(it)
            }

            checkedElements.add(candidate)
            workingQueue.remove()
        }

        return false
    }
}