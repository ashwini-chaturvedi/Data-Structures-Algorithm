```java
class Solution {
    static int MCM(int[] arr,int i,int j,int[][] memoiz){
        if(i>=j) return 0;//todo:
        
        
        if(memoiz[i][j]!=-1){
            return memoiz[i][j];
        }
        int minVal=Integer.MAX_VALUE;
        
        for(int k=i;k<j=-1;k++){//todo:
            int firstHalf=MCM(arr,i,k,memoiz);
            int secondHalf=MCM(arr,k+1,j,memoiz);
            
            //This arr[i-1]*arr[k]*arr[j] is to merge the answers from both half to find the tempAns for current i & j.
            int tempAns=firstHalf+(arr[i-1]*arr[k]*arr[j])+secondHalf;
            
            minVal=Math.min(minVal,tempAns);
        }
        return memoiz[i][j]=minVal;
    }
    static int matrixMultiplication(int[] arr) {
        
        //Since only two Parameters i and j are changing so we will memoiz on there basis 
        int[][] memoiz=new int[arr.length+1][arr.length+1];
        
        for(int[]memo:memoiz){
            Arrays.fill(memo,-1);
        }
        
        return MCM(arr,1,arr.length-1,memoiz);//Start from 1 to n-1 because to find the dimension of a Matrix (Ai=arr[i-1] X arr[i]) And (Aj=arr[j-1] X arr[j]).
    }
}
```
