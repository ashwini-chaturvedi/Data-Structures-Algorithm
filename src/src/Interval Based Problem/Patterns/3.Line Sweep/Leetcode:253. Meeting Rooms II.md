Given two arrays start[] and end[] such that start[i] is the starting time of ith meeting and end[i] is the ending time of ith meeting. Return the minimum number of rooms required to attend all meetings.

Note: A person can also attend a meeting if it's starting time is same as the previous meeting's ending time.

Examples:

Input: start[] = [1, 10, 7], end[] = [4, 15, 10]

Output: 1

Explanation: Since all the meetings are held at different times, it is possible to attend all the meetings in a single room.

```java
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        Arrays.sort(start);
        Arrays.sort(end);
        
        int i=0;
        int j=0;
        
        int n=start.length;
        
        int count=0;
        int max=0;
        
        while(i<n && j<n){
            if(start[i]<end[j]){
                count+=1;
                max=Math.max(max,count);
                i++;
            }else{
                count-=1;
                max=Math.max(max,count);
                j++;
            }
        }
        
        while(j<n){
            count-=1;
                max=Math.max(max,count);
                j++;
        }
        while(i<n){
            count+=1;
                max=Math.max(max,count);
                i++;
        }
        
        return max;
    }
}

```
