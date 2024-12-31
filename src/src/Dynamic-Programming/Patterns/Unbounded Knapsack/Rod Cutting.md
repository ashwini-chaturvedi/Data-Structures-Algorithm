```java
class Solution {
    //Unbounded Knapsack Problem just asked in different Problem
    public int cutRod(int[] price) {
        int n=price.length;
        
        //Make the Length Array Starting from 1 to n which shows possible number of pieces can be made of a Rod.
        int [] length=new int[n];
        for(int i=1;i<=n;i++){
            length[i-1]=i;
        }
        
        //All Similar to Knapsack just one change to include the Duplicates of an Item
        int[][] topDown=new int[n+1][n+1];//# IMPORTANT:used to store the profit when dividing the i length rod into j parts.
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){//this says that if the array size is zero or the parts to be divided is zero then we cannot get any profit and hence zero zero.
                    topDown[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
               if(length[i-1]<=j){
                   int include=price[i-1]+topDown[i][j-length[i-1]];//this i instead of i-1 will make the knapsack to have Duplicate Values
                   int exclude=topDown[i-1][j];
                   
                   topDown[i][j]=Math.max(include,exclude);
               }else{
                   topDown[i][j]=topDown[i-1][j];
               }
            }
        }
        
        return topDown[n][n];
    }
}
```
