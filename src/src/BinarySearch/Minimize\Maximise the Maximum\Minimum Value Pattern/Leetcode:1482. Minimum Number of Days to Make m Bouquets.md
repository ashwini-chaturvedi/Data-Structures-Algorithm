# Maximize the Minimum value Problem
```java
class Solution {
    //Time Complexity: O(Nlog(maxEle-minEle))
    public int numOfBouquets (int[]bloomDay,int mid,int adjFlowers){
        int bouquetCount=0;
        int consecutiveFlower=0;
        for(int num:bloomDay){
            if(num<=mid){
                consecutiveFlower++;
            }else{
                consecutiveFlower=0;
            }
            if(consecutiveFlower==adjFlowers){
                bouquetCount++;
                consecutiveFlower=0;
            }
        }
        return bouquetCount;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int num:bloomDay){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }

        int low=min;
        int high=max;
        int minDay=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(numOfBouquets(bloomDay,mid,k)>=m){
                minDay=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return minDay;
    }
}

```
