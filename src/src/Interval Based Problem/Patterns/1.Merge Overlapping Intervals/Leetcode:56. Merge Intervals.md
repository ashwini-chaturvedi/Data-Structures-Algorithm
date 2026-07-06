Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]

Output: [[1,6],[8,10],[15,18]]

Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

```java
class Solution {
    //Merge Overlapping Pattern:
    public int[][] mergeIntervals(int[][] intervals){
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

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
    public int[][] merge(int[][] intervals) {

        return mergeIntervals(intervals);
    }
}

```
