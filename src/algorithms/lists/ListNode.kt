package algorithms.lists

class ListNode {
    var value = 0
    var next: ListNode? = null
    var random: ListNode? = null

    internal constructor()
    internal constructor(value: Int) {
        this.value = value
    }

    internal constructor(value: Int, next: ListNode) {
        this.value = value
        this.next = next
    }

    internal constructor(value: Int, next: ListNode, random: ListNode) {
        this.value = value
        this.next = next
        this.random = random
    }

    override fun toString(): String {
        return "val: " + value + "; " +
                "next: " + next +
                "randomLink: " + random
    }
}