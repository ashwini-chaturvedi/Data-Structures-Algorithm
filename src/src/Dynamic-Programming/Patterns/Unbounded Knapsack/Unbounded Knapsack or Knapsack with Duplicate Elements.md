```java
class Solution {
    //  0/1 Knapsack with Duplicate Elements Allowed=Unbound Knapsack 
    static int knapSack(int val[], int wt[], int target) {
        int n=wt.length;
        
        int[][] topDown=new int[n+1][target+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                if(i==0 || j==0) topDown[i][j]=0;
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                if(wt[i-1]<=j){
                    int include=val[i-1]+topDown[i][j-wt[i-1]]; // #ONLY CHANGE:i-1 changes to i because we can include Duplicate element
                    
                    int exclude=topDown[i-1][j];
                    
                    topDown[i][j]=Math.max(include,exclude);
                }else{
                    topDown[i][j]=topDown[i-1][j];
                }
            }
        }
        
        return topDown[n][target];
    }
}
```
