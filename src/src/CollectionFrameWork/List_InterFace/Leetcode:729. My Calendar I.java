//Store the events as a sorted list of intervals. 
//If none of the events conflict, then the new event can be added.
class MyCalendar {
    List<int[]>list;
    public MyCalendar() {
       list=new ArrayList<>();
    }
    //Checking if the two Intervals are forming an Overlap.
    public boolean isOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
        //For Intervals to be Overlapped:if the maximum of start points is less than the minimum of the Ending point. 
    }
    public boolean book(int start, int end) {
        // Check for conflicts with any existing booking
        for (int[] event : list) {
            if (isOverlap(event[0],event[1],start,end)) {
// If maximum of start is less than min of end whivh means any one of the interval has an End point in between.
                // Overlap condition: start of the new event is before the end of an existing one,
                // and the end of the new event is after the start of the existing one.
                return false; // Conflict, so can't book this time slot
            }
        }
        // No conflicts, add the new booking
        list.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
