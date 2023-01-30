package algorithms.lists

object CopierRandomLinks {

    @JvmStatic
    fun main(args: Array<String>) {
        val initialList = buildList()
        val copiedlList = buildListWithOneLink()

        copyAllRandomLinks(initialList, copiedlList)
    }

    private fun buildList(): ListNode {
        val firstNode = ListNode(value = 0)
        val secondNode = ListNode(value = 1)
        val thirdNode = ListNode(value = 2)
        val fourthNode = ListNode(value = 3)
        val fifthNode = ListNode(value = 4)

        // add next
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = fourthNode
        fourthNode.next = fifthNode

        //add random link
        firstNode.random = firstNode
        secondNode.random = firstNode
        thirdNode.random = firstNode
        fourthNode.random = thirdNode
        fifthNode.random = thirdNode

        return firstNode
    }

    private fun buildListWithOneLink(): ListNode {
        val firstNode = ListNode(value = 5)
        val secondNode = ListNode(value = 6)
        val thirdNode = ListNode(value = 7)
        val fourthNode = ListNode(value = 8)
        val fifthNode = ListNode(value = 9)

        // add next
        firstNode.next = secondNode
        secondNode.next = thirdNode
        thirdNode.next = fourthNode
        fourthNode.next = fifthNode

        return firstNode
    }

    private fun copyAllRandomLinks(sourceList: ListNode, copiedList: ListNode) {
        var firstIter = sourceList
        var secondIter = copiedList

        while (firstIter.next != null) {
            secondIter.random = firstIter.random

            firstIter = firstIter.next!!
            secondIter = secondIter.next!!

        }

        //for last node in the list
        secondIter.random = firstIter.random
    }
}