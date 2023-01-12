package algorithms;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] initialArray = {3, 4, 1, 8, 10, 34, 5, 6, 9};

        sortArray(initialArray);
    }

    private static void sortArray(int[] messedArray) {
        System.out.println("Initial array: " + Arrays.toString(messedArray));
        buildHeap(messedArray);
        System.out.println("Build max-heap: " + Arrays.toString(messedArray));

        int size = messedArray.length;
        while (size > 1) {
            swap(messedArray, 0, size - 1);
            size--;
            heapify(messedArray, 0, size);
        }

        System.out.println("Sorted array: " + Arrays.toString(messedArray));
    }

    private static void heapify(int[] array, int currentIndex, int size) {
        int maxIndex = currentIndex;
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;

        if (leftChildIndex < size && array[maxIndex] < array[leftChildIndex]) {
            maxIndex = leftChildIndex;
        }

        if (rightChildIndex < size && array[maxIndex] < array[rightChildIndex]) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != currentIndex) {
            swap(array, currentIndex, maxIndex);
            heapify(array, maxIndex, size);
        }
    }

    private static void swap(int[] array, int currentIndex, int maxIndex) {
        int tmpMax = array[maxIndex];

        array[maxIndex] = array[currentIndex];
        array[currentIndex] = tmpMax;
    }

    private static void buildHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }
    }

}