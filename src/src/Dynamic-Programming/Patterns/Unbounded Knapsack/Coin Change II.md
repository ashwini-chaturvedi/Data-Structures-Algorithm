```java

class Solution {
    //Subset sum in Unbounded KnapSack
    //Similar to Subset Sum Problem but the Duplicates are allowed hence subset sum in Unbounded KnapSack
    public int change(int amount, int[] coins) {
         int n=coins.length;

        int[][] topDown=new int[n+1][amount+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<amount+1;j++){
                if(i==0 ) topDown[i][j]=0;

                if(j==0) topDown[i][j]=1;//Array of any size can have empty subset that can be used to form the sum equal to Zero arrangement.
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    int include=topDown[i][j-coins[i-1]];//i instead of i-1 because Duplicates are Allowed.
                    int exclude=topDown[i-1][j];

                    topDown[i][j]=include+exclude;
                }else{
                    topDown[i][j]=topDown[i-1][j];
                }
            }
        }

        return topDown[n][amount];
    }
}
```
