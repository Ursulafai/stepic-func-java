package algorithms

object QuickSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val initialArray = intArrayOf(3, 4, 1, 11, 10, 34, 5, 6, 9)
        quickSort(initialArray, initialArray[0], initialArray.lastIndex)
    }

    private fun partitioning(intArray: IntArray, left: Int, right: Int): Int {
//        val randomIndex = Random().nextInt(right - 1)
        val pivot = intArray[right]

        var i = left - 1 // Index of smaller element and indicates the right position of pivot found so far

        for (j in left until right) {

            // If current element is smaller than the pivot
            if (intArray[j] < pivot) {
                i++   // increment index of smaller element
                swap(intArray, j, i)
            }
        }
        swap(intArray, i + 1, right)
        return (i + 1)
    }

    private fun quickSort(intArray: IntArray, left: Int, right: Int) {
        if (left > right) {
            return
        }

        val m = partitioning(intArray, left, right)
        quickSort(intArray, left, m - 1)
        quickSort(intArray, m + 1, right)
    }

    private fun swap(intArray: IntArray, left: Int, right: Int) {
        if (left == right) {
            return
        }
        val tmp = intArray[left]

        intArray[left] = intArray[right]
        intArray[right] = tmp
    }
}