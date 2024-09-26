//Store the events as a sorted list of intervals. 
//If none of the events conflict, then the new event can be added.
class MyCalendar {
    List<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check for conflicts with any existing booking
        for (int[] event : list) {
            if (start < event[1] && end > event[0]) {
                // Overlap condition: start of the new event is before the end of an existing one,
                // and the end of the new event is after the start of the existing one.
                return false; // Conflict, so can't book this time slot
            }
        }
        // No conflicts, add the new booking
        list.add(new int[] { start, end });
        return true;
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
