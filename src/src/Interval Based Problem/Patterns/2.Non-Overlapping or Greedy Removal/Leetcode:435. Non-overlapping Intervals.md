Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]

Output: 1

Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.


```java
class Solution {
    //Non-Overlapping/Greedy Removal Pattern: Here we have to tell how many Overlapping intervals are to be Removed.so we will count when we saw an overlapping interval but we will keep the interval ending earlier
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);

        int[] prevInterval=intervals[0];
        int count=0;

        for(int i=1;i<intervals.length;i++){
            if(prevInterval[1]>intervals[i][0]){
                count++;
                prevInterval[1]=Math.min(prevInterval[1],intervals[i][1]);//keeping the interval ending earlier

            }else{
                
                prevInterval=intervals[i];
            }
        }

        return count;
    }
}
```
