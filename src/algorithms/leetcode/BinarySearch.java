package algorithms.leetcode;

import static java.lang.Math.min;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {11,13,15,17};

        System.out.println(findElementInRotatedArray(array));
    }

    static int findElementInRotatedArray(int[] nums) {
        int rightPosition = nums.length - 1;
        int leftPosition = 0;
        int midPosition;

        if (nums.length == 2)
            return min(nums[0], nums[1]);

        if (nums[leftPosition] < nums[rightPosition])
            return nums[leftPosition];

        while (leftPosition < rightPosition) {
            midPosition = (leftPosition + rightPosition) / 2;

            int leftNeibor = midPosition - 1;
            int rightNeibor = midPosition + 1;

            if (leftNeibor < 0) leftNeibor = leftPosition;
            if (rightNeibor == nums.length) rightNeibor = rightPosition;

            int leftGroup = min(nums[leftPosition], nums[leftNeibor]);
            int rightGroup = min(nums[rightPosition], nums[rightNeibor]);

            if (leftGroup < rightGroup) {
                if (nums[midPosition] <= leftGroup)
                    return nums[midPosition];
                rightPosition = midPosition - 1;
            } else {
                if (nums[midPosition] <= rightGroup)
                    return nums[midPosition];
                leftPosition = midPosition + 1;
            }
        }

        return nums[leftPosition];
    }
}