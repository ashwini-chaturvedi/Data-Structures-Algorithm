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
