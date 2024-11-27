```java
//Checking if the two Intervals are forming an Overlap.
public boolean isOverlap(int start1, int end1, int start2, int end2) {
  return Math.max(start1, start2) < Math.min(end1, end2);
//For Intervals to be Overlapped:if the maximum of start points is less than the minimum of the Ending point. 
}
```

```java
//Finding the Overlaping region between two Intervals.
public int[] overlapingRegion(int start1, int end1, int start2, int end2) {
  return new int[] { Math.max(start1, start2), Math.min(end1, end2) };
//For finding the Overlapped Intervals:Interval between the maximum of start points and minimum of the Endpoints.
}
```
