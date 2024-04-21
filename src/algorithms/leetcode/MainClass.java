package algorithms.leetcode;

import algorithms.leetcode.structures.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class MainClass {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);

        System.out.println(hasCycle(node1));
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

    public static ListNode reverseListRec(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;
        if (head.next.next == null) {
            ListNode next = head.next;
            head.next.next = head;
            head.next = null;
            return next;
        }

        return reverseListRecurs(head);
    }

    private static ListNode reverseListRecurs(ListNode head) {
        if (head.next.next == null) {
            head.next.next = head;

            return head.next;
        } else {

            ListNode newHead = reverseListRecurs(head.next);
            head.next.next = head;
            head.next = null;

            return newHead;
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode tmpP = null;
        ListNode tmpF = null;

        while (head.next.next != null) {

            if (tmpP == null)
            {
                tmpP = head;
                head = head.next;
                tmpF = head.next;
                tmpP.next = null;
            }

            else {
                head.next = tmpP;
                tmpP = head;
                head = tmpF;
                tmpF = head.next;
            }

        }

        head.next = tmpP;
        tmpF.next = head;

        return tmpF;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode firstPointer = head;
        ListNode secondPointer = head.next;

        while (firstPointer.next != null) {
            if (secondPointer.next == null || secondPointer.next.next == null) return false;
            if (firstPointer.next == secondPointer.next ||
            firstPointer.next == secondPointer.next.next) return true;

            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }

        return false;
    }
}