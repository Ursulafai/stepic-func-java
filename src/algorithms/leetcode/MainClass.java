package algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class MainClass {
    public static void main(String[] args) {
        String s = ",.";
        System.out.println(isPalindrome(s));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);

            if (hashSet.size() < i + 1)
                return true;
        }

        return false;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < t.length(); i++) {
            Integer value = map.get(t.charAt(i));
            if (value == null || value < 1) {
                return false;
            } else {
                map.put(t.charAt(i), value - 1);
            }
        }

        return true;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> firstParts = new HashMap<>();
        firstParts.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            Integer firstPartIndex = firstParts.get(target - nums[i]);
            if (firstPartIndex != null) return new int[]{firstPartIndex, i};

            firstParts.put(nums[i], i);
        }
        return new int[]{};

    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) return true;

        String lowerCased = s.toLowerCase();

        int i = 0;
        int j = lowerCased.length() - 1;

        while (i < j) {
            while (i < j && !isAlphanumeric(lowerCased.charAt(i))) {
                i++;
            }

            while (j > i && !isAlphanumeric(lowerCased.charAt(j))) {
                j--;
            }

            if (lowerCased.charAt(i) == lowerCased.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    static boolean isAlphanumeric(char ch) {
        return Character.isDigit(ch) || Character.isLetter(ch);
    }
}