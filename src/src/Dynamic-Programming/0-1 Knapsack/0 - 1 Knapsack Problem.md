```java
//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            // Read capacity
            int capacity = Integer.parseInt(br.readLine());

            // Read values
            String[] valInput = br.readLine().split(" ");
            int[] val = new int[valInput.length];
            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            // Read weights
            String[] wtInput = br.readLine().split(" ");
            int[] wt = new int[wtInput.length];
            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            // Call the knapSack function and print the result
            System.out.println(Solution.knapSack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


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
