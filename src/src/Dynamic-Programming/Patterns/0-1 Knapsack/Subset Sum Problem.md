```java

class Solution {
    /*How it is Similar to Knapsack:
    1. An array is Given & a Constraint/Weight type Target is Given
    2. We would have to pick Elements from the Array in such a way that the sum becomes 
       equal to target.
    
    Approach:
    1. We will consider arr as Array of Items & Target as maximum allowed weight in knapsack
    2. Now we will use Top-Down because we have to pick the elements whose sum equals to Target
        and the Index of the array & target is changing for Every Sub problem.
    3. Initialization:When Index is 0 means the array is empty then we cannot make any sum from an Empty Array. 
    4. But when the target is 0 we can make sum zero so true because every array has an Empty Subset/Null Subset
    5. Now Either Chose the Element to be Part of the Sum or don't choose it.
    6. Bit-wise OR checks if either by including or by excluding do the target sum is Achived
    5. Atlast,check the last cell of the Matrix...
    
    #Important
        1. []wt-------->[]arr
        2. W----------->sum/target
    */
    static Boolean isSubsetSum(int arr[], int target) {
        int n=arr.length;
        
        boolean[][] topDown=new boolean[n+1][target+1];
        
        //'i' Represent Array Index.
        //'j' Represent Target Value.
         for(int i=0;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                
                //Initialization
                if(i==0){//Base Case/Initialization when target is achieved or the array is ended
                    topDown[i][j]=false;
                }
                if(j==0){
                    topDown[i][j]=true;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                
                if(arr[i-1]<=j){
            //Since value/Profit array is Not given so ignore the adding of the values
                    boolean include=topDown[i-1][j-arr[i-1]];
    //j-arr[i-1] tells that we are taking this Element so we are minusing the taken element from the target ans making the Cell at Remaining's Index True.
                    boolean exclude=topDown[i-1][j];
                    
                    topDown[i][j]=include||exclude;
                }else{
                    topDown[i][j]=topDown[i-1][j];
                }
            }
        }
        
      
        return topDown[n][target];
    }
}
```
