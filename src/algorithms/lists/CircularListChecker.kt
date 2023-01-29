package algorithms.lists

object CircularListChecker {
    @JvmStatic
    fun main(args: Array<String>) {
        val firstNode = buildList()

        println(checkForCircular(firstNode))
    }

    private fun buildList(): ListNode {
        val firstNode = ListNode(value = 0)
        val secondNode = ListNode(value = 1)
        val thirdNode = ListNode(value = 2)
        val fourthNode = ListNode(value = 3)
        val fifthNode = ListNode(value = 4)

        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = fourthNode
        fourthNode.next = fifthNode

        //comment this to check not circular list
        fifthNode.next = thirdNode

        return firstNode
    }

    private fun checkForCircular(
        list: ListNode
    ): Boolean {

        var firstIterator = list
        var secondIterator = list.next!!.next

        while (secondIterator?.next?.next != null && firstIterator.next != null) {
            if (firstIterator == secondIterator)
                return true

            firstIterator = firstIterator.next!!
            secondIterator = secondIterator.next!!.next
        }

        return false
    }
}