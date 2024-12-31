```java
class Solution {
    public int perfectSum(int[] nums, int target) {
        // 0/1 Knapsack Problem 
        
        int[][] topDown=new int[nums.length+1][target+1];//we will now use this 2D array to store the frequqncy of the occurence of the sum 'j' at the index i
        
        for(int i=0;i<nums.length+1;i++){
            for(int j=0;j<target+1;j++){
                if(i==0) {
                    topDown[i][j]=0;
                }
                if(j==0){
                    topDown[i][j]=1;//Only a null/Empty Subset can give us sum equal to zero
                    //So the only 1 because we are able to find only one subset equal to sum 0
                }
            }
        }
        for(int i=1;i<nums.length+1;i++){
            for(int j=0;j<target+1;j++){/*here we will start from 0 and not 2 because according to the constraint 
            there might be 0 as element so we have to manipulate the Initialization row column also to get the result as the 
            occurence of 0 will be 2 after 5 index in array because at index 4 zero is present*/
                
                if(nums[i-1]<=j){
                    int include=topDown[i-1][j-nums[i-1]];
                    int exclude=topDown[i-1][j];
                    
                    topDown[i][j]=include+exclude;//sum the include or exclude because by excluding we might get the target and by 
                    //Including we also might get the target this is because some elements might leave the subset to make the sum equal to target.
                    
                }else{
                    topDown[i][j]=topDown[i-1][j];
                }
            }
        }
        
        return topDown[nums.length][target];
    }
}
```
