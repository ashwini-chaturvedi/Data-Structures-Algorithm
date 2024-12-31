```java
class Solution {
    int countPartitions(int[] arr, int d) {
        //find the sum of the Array.
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        
        if((d+sum)%2!=0) return 0;//if the sum + diff for the Elements in array arr ,then return 0 because it can never form a subset with diff equal to sum 
        int target=(d+sum)/2;//Calculated Mathematically
        
        
        //Now again 0/1 Knapsack Problem...
        int[][] topDown=new int[arr.length+1][target+1];
        
        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<target+1;j++){
                
                if(i==0) topDown[i][j]=0;
                
                if(j==0) topDown[i][j]=1;
            }
        }
        
        for(int i=1;i<arr.length+1;i++){
            for(int j=0;j<target+1;j++){
                
                if(arr[i-1]<=j){
                    int include=topDown[i-1][j-arr[i-1]];
                    int exclude=topDown[i-1][j];
                    
                    topDown[i][j]=include+exclude;
                }else{
                    topDown[i][j]=topDown[i-1][j];
                }
            }
        }
        
        return topDown[arr.length][target];
    }
}
```
