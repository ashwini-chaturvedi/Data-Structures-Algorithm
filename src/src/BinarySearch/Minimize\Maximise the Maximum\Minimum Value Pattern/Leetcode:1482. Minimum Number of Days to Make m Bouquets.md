# Maximize the Minimum value Problem

```java
1. We can start from Minimum day i.e.1 and can wait until the Maximum Day for the Flower to Bloom i.e maximum value in array 'bloom Day'
2. Now, we will apply Binary Search on this Interval:
        [startDay=minimum of the'bloom Day' (or) 1 to endDay=Maximum of 'bloom Day']
3. we check on the Mid day if it can make a Boquet
        i.Yes, then Store the Result ans try to find miss less so we will go towards Low: high=mid-1.
        ii.No, then we will increase the Days as low=mid+1.
```
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
