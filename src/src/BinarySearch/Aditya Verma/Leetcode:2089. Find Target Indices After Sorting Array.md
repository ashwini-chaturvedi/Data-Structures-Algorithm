You are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

 

Example 1:

Input: nums = [1,2,5,2,3], target = 2

Output: [1,2]

Explanation: After sorting, nums is [1,2,2,3,5].
The indices where nums[i] == 2 are 1 and 2.

```java
class Solution {
    public int binarySearch(int[] nums,int target,boolean flag){
        int low=0;
        int high=nums.length-1;

        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
               ans=mid;
               if(flag){
                high=mid-1;
               }else{                
                low=mid+1;
               }
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return ans;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer>list=new ArrayList<>();
        Arrays.sort(nums);

        int firstOccur=binarySearch(nums,target,true);
        int lastOccur=binarySearch(nums,target,false);

        if(firstOccur==-1 && lastOccur==-1 ) return list;

        for(int i=firstOccur;i<=lastOccur;i++){
            list.add(i);
        }

        Collections.sort(list);  

        return list;
    }
}
```
