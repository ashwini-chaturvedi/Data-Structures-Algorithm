Dilpreet wants to paint his dog's home that has n boards with different lengths. The length of ith board is given by arr[i] where arr[] is an array of n integers. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.

Return the minimum time to get this job done if all painters start together with the constraint that any painter will only paint continuous boards, say boards numbered [2,3,4] or only board [1] or nothing but not boards [2,4,5].

Examples:

Input: arr[] = [5, 10, 30, 20, 15], k = 3
Output: 35
Explanation: The most optimal way will be: Painter 1 allocation : [5,10], Painter 2 allocation : [30], Painter 3 allocation : [20,15], Job will be done when all painters finish i.e. at time = max(5+10, 30, 20+15) = 35
```java
class Solution {
    public boolean isValid(int[] Boards,int Painters,int maxAllowed){
        int painter=1;
        int colored=0;
        
        for(int board:Boards){
            colored+=board;
            
            if(colored>maxAllowed){
                colored=board;
                painter++;
            }
            
            if(painter>Painters) return false;
        }
        return true;
    }
    public int minTime(int[] Boards, int Painters) {
        
        int low=0;
        int high=0;
        
        for(int board:Boards){
            low=Math.max(low,board);
            high+=board;
        }
        
        int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(isValid(Boards,Painters,mid)){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
}
```
