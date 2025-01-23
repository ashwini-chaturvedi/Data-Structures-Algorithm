Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```java
class Solution {
    //we have to find the Starting Element of a consecutive sequence and a starting element will don't have its Previous Element in to the Array e.g  [100,4,200,1,3,2] here 1 is Starting of the Sequence 1,2,3,4 because 1-1=0 is not in the nums if there was 0 present it would have become the Starting Point
    public int longestConsecutive(int[] nums) {
        //Add all the Element in the Set so that we can check if Previous Element is Present or not.
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int length=0;
        for(int num:set){//Traverse on Set Because There Might be Duplicate Elements in Nums which will Increase the TIme so that is Why traverse on Set it has all unique elements.
            if(!set.contains(num-1)){//if set does not contains Element previous to num
                int count=1;//1 Element i.e. Starting Element of the Sequence is Found now find the Sequence and Increase the Count.
                while(set.contains(num+1)){
                    count++;
                    num=num+1;
                }
                length=Math.max(length,count);//Max Length of Consecutive Sequence.
            }
        }
        return length;
    }
}
```
