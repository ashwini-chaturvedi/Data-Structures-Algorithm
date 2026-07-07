Given a 2D array arr[][], where arr[i][0] is the starting time of ith meeting and arr[i][1] is the ending time of ith meeting, the task is to check if it is possible for a person to attend all the meetings such that he can attend only one meeting at a particular time.

Note: A person can attend a meeting if its starting time is greater than or equal to the previous meeting's ending time.

Examples:

Input: arr[][] = [[1, 4], [10, 15], [7, 10]]

Output: true

Explanation: Since all the meetings are held at different times, it is possible to attend all the meetings.

```java
class Solution {
    static boolean canAttend(int[][] arr) {
        //we have to check that there is no Overlapping
        
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        
        int[] prevInterval=arr[0];
        
        for(int i=1;i<arr.length;i++){
            if(prevInterval[1]>arr[i][0]) return false;
            else{
                prevInterval=arr[i];
            }
        }
        
        return true;
    }
}
```
