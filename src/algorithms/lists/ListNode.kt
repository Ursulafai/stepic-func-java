package algorithms.lists

class ListNode {
    var value = 0
    var next: ListNode? = null

    internal constructor()
    internal constructor(value: Int) {
        this.value = value
    }

    internal constructor(value: Int, next: ListNode) {
        this.value = value
        this.next = next
    }

    override fun toString(): String {
        return "val: " + value + "; " +
                "next: " + next
    }
}