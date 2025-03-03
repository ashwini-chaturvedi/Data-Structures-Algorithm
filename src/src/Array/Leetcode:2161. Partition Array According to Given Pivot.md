You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:

Every element less than pivot appears before every element greater than pivot.
Every element equal to pivot appears in between the elements less than and greater than pivot.
The relative order of the elements less than pivot and the elements greater than pivot is maintained.
More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
Return nums after the rearrangement.

 

Example 1:

Input: nums = [9,12,5,10,14,3,10], pivot = 10
Output: [9,5,3,10,10,12,14]
Explanation: 
The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
The relative ordering of the elements less than and greater than pivot is also maintained. [9, 5, 3] and [12, 14] are the respective orderings.

```java
class Solution {

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> large = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                small.add(num);
            } else if (num > pivot) {
                large.add(num);
            } else {
                equal.add(num);
            }
        }

        int[] res = new int[nums.length];

        int i = 0;
        int j = 0;
        while (j < small.size()) {
            res[i++] = small.get(j++);
        }
        int k = 0;
        while (k < equal.size()) {
            res[i++] = equal.get(k++);
        }
        int l = 0;
        while (l < large.size()) {
            res[i++] = large.get(l++);
        }

        return res;
    }
}

```
