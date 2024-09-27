#IMPORTANT:ALWAYS MAKE a NUMBER LINE FOR INTERVAL Pattern PROBLEM.
// 1. Checking if two Intervals are Overlapped=Math.max(start1,start2)<Math.min(end1,end2).
// 2. Finding the Overlapping Region=[Math.max(start1,start2)<Math.min(end1,end2)].
  
class MyCalendarTwo {
    List<int[]> doubleOverlap;
    List<int[]> singleOverlap;

    public MyCalendarTwo() {
        singleOverlap = new ArrayList<>();
        doubleOverlap = new ArrayList<>();
    }

//Checking if the two Intervals are forming an Overlap.
    public boolean isOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
        //For Intervals to be Overlapped:if the maximum of start points is less than the minimum of the Ending point. 
    }
//Finding the Overlaping region between two Intervals.
    public int[] overlapRegion(int start1, int end1, int start2, int end2) {
        return new int[] { Math.max(start1, start2), Math.min(end1, end2) };
        //For finding the Overlapped Intervals:Interval between the maximum of start points and minimum of the Endpoints.
    }

    public boolean book(int start, int end) {

        //Checking for Triple Booking...
        for (int[] event : doubleOverlap) {
            if (isOverlap(event[0], event[1], start, end)) {
                return false; //if this Interval is Forming any overlap with the Interval that are already overlaped twice it will be forming a triple overlap which is Invalid.
            }
        }
//Checking for double booking...
        for (int[] event : singleOverlap) {
            if (isOverlap(event[0], event[1], start, end)) {
                doubleOverlap.add(overlapRegion(event[0], event[1], start, end));
            }
        }
//At last add the booking to single booking as it is the first time there is a booking in this Interval...
        singleOverlap.add(new int[] { start, end });
        return true;
    }
}
/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
