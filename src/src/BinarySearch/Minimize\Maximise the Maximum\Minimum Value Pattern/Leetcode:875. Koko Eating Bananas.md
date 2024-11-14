```java
class Solution {
    public boolean canEat(int []piles,int mid,int h){
        long curr=0;
        for(int num:piles){
           curr+=(num+mid-1)/mid;
           
           if(curr>Integer.MAX_VALUE) return false;
        }
        return (int) curr<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        
        for(int num:piles){
           
            max=Math.max(max,num);
        }
        int low=1;
        int high=max;
        int res=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canEat(piles,mid,h)){
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
