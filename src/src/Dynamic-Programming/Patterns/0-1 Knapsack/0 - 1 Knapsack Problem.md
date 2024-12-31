# Recursive + Memoization
```java
class Solution {
    public static int Knapsack(int[]wt,int[]profit,int W,int n,int[][] memoiz){
        if(n==0 || W==0) return 0;//smallest valid Input will be Either the wt array or profit array becomes empty or the knapsack becomes full so that is why either W==0 or n==0
        //if this happens the profit will be zero so return 0.
        
        if(memoiz[n][W]!=-1){
            return memoiz[n][W];
        }
        if(wt[n-1]<=W){/*When the Weight of Item is less equal to the Allowed maximum weight in knapsack 
        then you have 2 options
        1.To Include the Current ELement
        2.To Exclude the Current ELement
        
        
        Either Include the Current element at n-1 or Exclude it*/
            
            int include=profit[n-1]+Knapsack(wt,profit,W-wt[n-1],n-1,memoiz);//When Including the current element we take the Profit of it hence add the value as profit and decrease the weight of the element from total weight in knapsack so to find the remaining Weight in the Bag
            int exclude=Knapsack(wt,profit,W,n-1,memoiz);
            
            
            //Find the Maximum profit between including or Excluding store it in memoiz Matrix
            return memoiz[n][W]=Math.max(include,exclude);
        }else{//if the weight of the element is greater than the maximum allowed weight of knapsack hence we have no option other than Excluding it
            return memoiz[n][W]=Knapsack(wt,profit,W,n-1,memoiz);
        }
    }
    static int knapSack(int capacity, int val[], int wt[]) {
        int n=wt.length;
        int W=capacity;
        
        int[][] memoiz=new int[n+1][W+1];//Since Only n & W are changing in the Recursive call we will store the n & W values in a 2D array
        // or we can say we will only memoiz values for n & W
        
        for(int[] memo:memoiz){
            for(int i=0;i<memo.length;i++){
                memo[i]=-1;
            }
        }
        return Knapsack(wt,val,W,n,memoiz);
    }
}

```
# Top-Down 
```java
class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int P[], int wt[]) {
        int n=wt.length;
        int W=capacity;
        
        int[][]topDown=new int[n+1][W+1];//2D Grid for Top-Down Approach
        
        //Intialization this is Similar to as Base Case in Recursive Code
        //Since here the base value is 0 we can avoid this because by default value in integer is zero.
        //But if other that 0 any other base value then you shoul use this 
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 || j==0){
                    topDown[i][j]=0;
                }
            }
        }
        
        //Now Converting the Recursive Tree Code into Iterative Code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){//When the weight of the current Element is less then the Weight allowed for a Sub Problem 
                //Each Cell Represents another SUBproblem of how they can fit n-1 objects with weight limit of W-1.
                
                //Since Only weight and size of the Array is varying so they would be our reference point
                
                
                //We will Use Prevoisly Filled Connected cells to Determine the value of current cell
                    int include=P[i-1]+topDown[i-1][j-wt[i-1]];
                    int exclude=topDown[i-1][j];
                    
                    topDown[i][j]=Math.max(include,exclude);
                }else{//if the weight of the Element is Greater then the allowed weight for Knapsack
                    topDown[i][j]=topDown[i-1][j];
                }
            }
        }
        return topDown[n][W];//Last cell will have the value
    }
}

```
