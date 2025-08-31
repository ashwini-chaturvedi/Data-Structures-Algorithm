```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        Arrays.sort(nums);//Sorting

        for(int i=0;i<nums.length-2;i++){//last ka 2 chod dunga kyu ki atleast 3 number chahiye

            if(i>0 && nums[i]==nums[i-1]) continue;//ignoring the Duplicate numbers

            int low=i+1;//hmesha ek aage se start krna h kyuki array sorted h 
            int high=nums.length-1;

            while(low<high){
                int sum=nums[i]+nums[low]+nums[high];

                if(sum==0){
                    list.add(Arrays.asList(nums[i],nums[low],nums[high]));//when sum is zero then add it to the list...

                    //Now Skipping the Duplicate numbers...
                    while(low<high && nums[low]==nums[low+1]) low++;
                    while(low<high && nums[high]==nums[high-1]) high--;

                    low++;
                    high--;
                }else if(sum<0){
                    low++;//when sum is less then zero so we move towards the bigger Numbers so that the sum can be Increased...
                }else{
                    high--;//to Decrease the sum we move towards left or lower valued..
                }
            }
        }

        return list;
    }
}
```
