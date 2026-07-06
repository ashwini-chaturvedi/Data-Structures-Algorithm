You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]

Output: [[1,2],[3,10],[12,16]]

Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
```java
class Solution {
    public int[][] mergeIntervals(int[][] intervals){
       // Arrays.sort(intervals,(a,b)->a[0]-b[0]); Since intervals are already sorted.

        List<int[]> list = new ArrayList<>();

        int[] prev=intervals[0];//take the first Interval

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prev[1]) {//if(curr.start<=prevEnd) then MERGE
                prev[1]=Math.max(intervals[i][1],prev[1]);//for Merging change the endTime to maximum of both the ends
            } else {//if current Interval is not overlapping then add the prev Interval to ans and make the current interval new prev Interval.
                list.add(new int[]{prev[0],prev[1]});
                prev=intervals[i];
            }
        }

        list.add(prev);//add the remaining last interval to the ans.

        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }

        return ans;

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //First add the newInterval into its correct place sorted by start time and then run the merging Algo
        if(intervals.length<1){
            intervals=new int[1][2];
            intervals[0][0]=newInterval[0];
            intervals[0][1]=newInterval[1];

            return intervals;
        }
        List<int[]>prev=new ArrayList<>();
       
        boolean isMerged=false;

        for(int[] interval:intervals){
            if(interval[0]>=newInterval[0]){
                prev.add(newInterval);
                isMerged=true;
                
            }

            prev.add(interval);

        }
        if(!isMerged){
            prev.add(newInterval);
        }

        intervals=new int[prev.size()][2];

        int i=0;
        for(int[] arr:prev){
            intervals[i][0]=arr[0];
            intervals[i][1]=arr[1];

            i++;
        }    

        return  mergeIntervals(intervals); 
    }
}
```
