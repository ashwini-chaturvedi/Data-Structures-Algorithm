package Strings;

import java.util.Scanner;
/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.*/

public class first_last_Occurence {

    public int firstOccurrence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int firstIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                firstIndex = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return firstIndex;
    }

    public int lastOccurence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int lastIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                lastIndex = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastIndex;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = firstOccurrence(nums, target);
        res[1] = lastOccurence(nums, target);
        return res;

    }
    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);

    }
}


