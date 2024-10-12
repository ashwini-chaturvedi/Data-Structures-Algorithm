//Approach:The minimum number of groups we need is equivalent to the maximum number of intervals that overlap at some point. How can you find that?
class Solution {
    public int minGroups(int[][] intervals) {
        //Sort the Intervals on the Basis of there Start Point.
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        //Use a minHeap to store the smallest encountered End point of any Interval
        PriorityQueue<Integer>minHeapForEnd=new PriorityQueue<>();

        for(int[] interval:intervals){
            int start=interval[0];
            int end=interval[1];

            //if the Smallest Possible End that is Still known and present in the minHeap is less then the Start of the Current Interval so now we can say that these both Intervals(Interval1 whose End point is in the minHeap and Interval2 that is Current Interval) will not Intersect at Any point.
            if(!minHeapForEnd.isEmpty() && minHeapForEnd.peek()<start){
                //Then both are not Colliding or Intersecting.
                minHeapForEnd.poll();//Since Both Intervals will Never Intersect so we can keep them in a Single Group.
            }
            minHeapForEnd.add(end);//Add the End of the Interval in the minHeap for checking the Intersection in later Intervals.
        }
        return minHeapForEnd.size();//Atlast only those Intervals will be Present in the minHeap those are Intersecting with each other and are hence kept in separate Groups.
    }
}
