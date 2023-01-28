package algorithms

import kotlin.random.Random


object QuickSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val initialArray = intArrayOf(3, 4, 1, 11, 10, 34, 5, 6, 9)
        println(initialArray.contentToString())
        quickSort(initialArray, 0, initialArray.lastIndex)
        println(initialArray.contentToString())
    }

    private fun partitioning(intArray: IntArray, left: Int, right: Int): Int {
        random(intArray, left, right)
        val pivotValue: Int = intArray[right]

        var i = left - 1 // Index of smaller element and indicates the right position of pivot found so far

        for (j in left until right) {

            // If current element is smaller than the pivot
            if (intArray[j] < pivotValue) {
                i++   // increment index of smaller element
                swap(intArray, j, i)
            }
        }
        swap(intArray, i + 1, right)
        return i + 1
    }

    private fun quickSort(intArray: IntArray, left: Int, right: Int) {
        if (left >= right) {
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

    private fun random(intArray: IntArray, left: Int, right: Int) {
        val rand = Random
        val pivot = rand.nextInt(right - left + left)

        swap(intArray, right, pivot)
    }
}