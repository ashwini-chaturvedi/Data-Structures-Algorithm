Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

- 0 <= a, b, c, d < n
- a, b, c, and d are distinct.
- nums[a] + nums[b] + nums[c] + nums[d] == target
  
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0

Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

# 3Sum + One Loop More

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>list=new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++){

            if(i>0 && nums[i]==nums[i-1]) continue;
            
            for(int j=i+1;j<nums.length-2;j++){

                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int low=j+1;
                int high=nums.length-1;

                while(low<high){
                    long sum=0;//Handling the overflow
                    sum+=nums[i];
                    sum+=nums[j];
                    sum+=nums[low];
                    sum+=nums[high];

                    if(sum==target){
                        list.add(new ArrayList<>(List.of(nums[i],nums[j],nums[low],nums[high])));

                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;

                        low++;
                        high--;
                    }else if(sum<target){
                        low++;
                    }else{
                        high--;
                    }

                }
            }
        }

        return list;
    }
}
```
