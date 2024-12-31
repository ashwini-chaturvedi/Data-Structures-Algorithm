```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int n=coins.length;

        int[][] topDown=new int[n+1][amount+1]; //we will use this 2D array to store the count of the coin needed to achieve the sum/amount
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<amount+1;j++){

                if(i==0) topDown[i][j]=Integer.MAX_VALUE-1;//koi bhi sum laane keliye ek empty array me se Infinite number of element choose krenge tbb shayad se woh sum miljaega

                if(j==0) topDown[i][j]=0;//kisi bhi size ke array me 0 sum laane ka 0 tarika hota h 

                if(i==1 && j!=0){
                    if(j%coins[0]==0){
                        topDown[i][j]=j/coins[0]; //0 because i is mapped to 1 index backward for intialization that is why we use i-1 to access elements from the array.
                        //we are doing this because in 1 size array only the value of that coin and its multiple can be achieved and not the non-multiple values so that is why we will mark the achievable sum with count/multiple of coin used and un-achievable with infinity (minus 1 for Safety).
                    }else{
                        topDown[i][j]=Integer.MAX_VALUE-1; 
                    }
                }
            }
        }
        
        for(int i=2;i<n+1;i++){//i starts from 2 because we have Initialized i=1.
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    int include=1+topDown[i][j-coins[i-1]];//plus one because this coin is included and we are trying to find number of coins to achieve the sum.Previously we were adding the value from the value array but here we have to find the number of coins so plus one after Including a coin.
                    int exclude=topDown[i-1][j];

                    topDown[i][j]=Math.min(include,exclude);//Minimum number of coins
                }else{
                    topDown[i][j]=topDown[i-1][j];
                }
            }
        }
       
        return topDown[n][amount]==Integer.MAX_VALUE-1?-1:topDown[n][amount];
    }
}
```
