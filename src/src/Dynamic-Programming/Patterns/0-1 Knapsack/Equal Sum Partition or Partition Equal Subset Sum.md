```java
/*
Its Asking for a Subset Sum and want the target to be the sum of the Rest of the Element in the Array.

Approach:
1. Find the Sum of all the Elements in the Array.
2. Now to get a Subarray equal to the sum of the all other remaining Element the target for the Sub array should be half of the Sum of all the Element in the array.
    Simple si baat h agr ekk subarray ke sum ko aur bche hue element ke sum ke equal hona h toh pure total sum ke half ke barabar hona hoga tbbhi dono trf equal hoga.
    (i) if the Sum is Odd number than we can't find any subarray of integer values whose sum equals to the half of an odd value because it will give decimal value.So,Return false.
    (ii) if the sum is even then this Problem Becomes a 0/1 KNAPSACK Problem with nums array as Weight array and half of the sum as the maximum weight allowed in KNAPSACK i.e. 'W'.
*/
class Solution {
    public boolean canPartition(int[] nums) {
        //Find SUM
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0) return false;//if Sum is Odd then Return False 

//      0/1 KNAPSACK PROBLEM

        int target=sum/2;//Weight Allowed in Knapsack

        boolean[][] topDown=new boolean[nums.length+1][target+1];

        for(int i=0;i<nums.length+1;i++){
            for(int j=0;j<target+1;j++){
                if(i==0) topDown[i][j]=false;//if Empty Array then No SUM can be Achieved
                if(j==0) topDown[i][j]=true;//if the Sum is 0 then any number size of Array can get it.
            }
        }

        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<target+1;j++){

                if(nums[i-1]<=j){
                    boolean include=topDown[i-1][j-nums[i-1]];//j-nums[i-1] tells that we have taken nums[i-1] Element and the remaining is j-nums[i-1] so just go and check the value at that Index.
                    boolean exclude=topDown[i-1][j];

                    topDown[i][j]=include || exclude;
                }else{
                    topDown[i][j]=topDown[i-1][j];
                }
            }
        }

        return topDown[nums.length][target];
    }
}
```
