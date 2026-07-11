A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)

You are given some events [startTime, endTime), after each given event, return an integer k representing the maximum k-booking between all the previous events.

- Implement the MyCalendarThree class:

- MyCalendarThree() Initializes the object.
int book(int startTime, int endTime) Returns an integer k representing the largest integer such that there exists a k-booking in the calendar.
 

Example 1:

Input
["MyCalendarThree", "book", "book", "book", "book", "book", "book"]

[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]

Output
[null, 1, 1, 2, 3, 3, 3]

Explanation

MyCalendarThree myCalendarThree = new MyCalendarThree();

myCalendarThree.book(10, 20); // return 1

myCalendarThree.book(50, 60); // return 1

myCalendarThree.book(10, 40); // return 2

myCalendarThree.book(5, 15); // return 3

myCalendarThree.book(5, 10); // return 3

myCalendarThree.book(25, 55); // return 3

```java
class MyCalendarThree {
    List<int[]>lineSweep;
    public MyCalendarThree() {
        lineSweep=new ArrayList<>();
    }
    
    public int book(int startTime, int endTime) {
        lineSweep.add(new int[]{startTime,1});
        lineSweep.add(new int[]{endTime,-1});

        lineSweep.sort((a,b)->a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));

        int count=0;
        int max=0;

        for(int[] line:lineSweep){
            int event=line[0];
            int delta=line[1];

            count+=delta;
            max=Math.max(max,count);
        }

        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
```
