A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]

Output: [1,3,2]

```java
class Solution {
    public void reverse(int[] nums, int idx) {
        int i = idx;
        int j = nums.length - 1;

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        //finding the pivot Index.
        int pIdx = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pIdx = i;
                break;
            }
        }

        //if we didn't find pivot.
        if (pIdx == -1) {
            reverse(nums, pIdx + 1);
            return;
        } else {//found pivot element's index

            //finding the first greater element from the end of the array
            int firstGreater = 0;
            for (int i = nums.length - 1; i > pIdx; i--) {
                if (nums[pIdx] < nums[i]) {
                    int temp = nums[pIdx];
                    nums[pIdx] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }

            reverse(nums, pIdx + 1);

        }

    }
}
```
