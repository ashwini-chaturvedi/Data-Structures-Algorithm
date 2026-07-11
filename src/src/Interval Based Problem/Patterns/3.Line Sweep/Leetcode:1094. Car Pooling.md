There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4

Output: false

```java
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[][] lineSweep=new int[trips.length*2][2];

        int i=0;
        for(int[] trip:trips){
            int noOfPassenger=trip[0];
            int from=trip[1];
            int to=trip[2];
            
            lineSweep[i++]=new int[]{from,noOfPassenger};
            lineSweep[i++]=new int[]{to,-noOfPassenger};
        }

        Arrays.sort(lineSweep,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int count=0;
        int max=0;

        for(int[] line:lineSweep){
            int event=line[0];
            int delta=line[1];

            count+=delta;

            max=Math.max(max,count);
        }

        return max<=capacity;
    }
}
```
