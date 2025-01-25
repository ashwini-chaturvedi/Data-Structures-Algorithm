You are given a 0-indexed array of positive integers nums and a positive integer limit.

In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.

Return the lexicographically smallest array that can be obtained by performing the operation any number of times.

An array a is lexicographically smaller than an array b if in the first position where a and b differ, array a has an element that is less than the corresponding element in b. For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.

 

Example 1:

Input: nums = [1,5,3,9,8], limit = 2

Output: [1,3,5,8,9]

Explanation: Apply the operation 2 times:
- Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
- Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
We cannot obtain a lexicographically smaller array by applying any more operations.
Note that it may be possible to get the same result by doing different operations.
```java
class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        //We will make groups of all the Elements that are related with each other and Satisfying the relation of | nums[i]-nums[j] |<=limit.

        Map<Integer, List<Integer>> groupToElements = new HashMap<>();//Map to Store the Group with all the Elements of that Particular Group
        groupToElements.put(0, new ArrayList<>());
        groupToElements.get(0).add(sortedNums[0]);

        Map<Integer, Integer> elementToGroup = new HashMap<>();//Map to Store which Element is present in Which Group
        elementToGroup.put(sortedNums[0], 0);

        int currGroup = 0;
        for (int i = 1; i < sortedNums.length; i++) {
            if (Math.abs(sortedNums[i] - sortedNums[i - 1]) > limit) {//if the Relation is not Satisfied Increase the Group from zero to one which is a different Group.
                currGroup++;
            }
            groupToElements.putIfAbsent(currGroup,new ArrayList<>());
            groupToElements.get(currGroup).add(sortedNums[i]);//Store the Group with the Element

            elementToGroup.put(sortedNums[i], currGroup);//Store the Element with the Group.
        }

        for (int i = 0; i < nums.length; i++) {
            int groupId = elementToGroup.get(nums[i]);//Find the Group 
            int smallestVal = groupToElements.get(groupId).remove(0);//Take the Smallest Possible Value of that Group

            nums[i] = smallestVal;//Change it to that
        }

        return nums;
    }
}

```
