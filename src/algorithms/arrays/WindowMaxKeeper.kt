package algorithms.arrays

object WindowMaxKeeper {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(4, 8, 1, 7, 0)
        findMaxInWindow(array, 2)
    }

    private fun findMaxInWindow(array: IntArray, windowSize: Int) {
        for (i in 0..array.size - windowSize) {
            var max = array[i]
            for (j in i until i + windowSize - 1) {

                if (array[j + 1] > max) {
                    max = array[j + 1]
                }
            }

            println("$max")
        }
    }
}