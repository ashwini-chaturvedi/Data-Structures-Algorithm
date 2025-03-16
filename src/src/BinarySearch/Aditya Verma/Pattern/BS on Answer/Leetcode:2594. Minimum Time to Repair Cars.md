You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.

You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.

Return the minimum time taken to repair all the cars.

Note: All the mechanics can repair the cars simultaneously.

 

Example 1:

Input: ranks = [4,2,3,1], cars = 10
Output: 16
Explanation: 
- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
- The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
- The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
- The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
Example 2:

Input: ranks = [5,1,8], cars = 6
Output: 16
Explanation: 
- The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 minutes.
- The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
- The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 minutes.
It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​

![image](https://github.com/user-attachments/assets/f6221a0d-1582-46b0-bf3b-ee7c171b68ac)

```java
class Solution {
    //We have to: MINIMIZE THE MAXIMUM TIME taken to repair all the cars

    public boolean Time(int[] ranks, long guessTime, int cars) {
        long carsRepaired = 0;//curr count of cars repaired

        for (int rank : ranks) {
            //We know Time=rank*(n*n), here we have time (i.e. guessTime) and we have the rank of every individual mechanic so now :*********** n=√Time/rank **********
            carsRepaired += (Math.sqrt(guessTime / rank));
        }
        //if the repairedCars count is greater than actually required then this guessTime can be our correct time
        return carsRepaired >= cars;
    }

    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = 0;
        for (int rank : ranks) {
            high = Math.max(high, rank);
        }

        high = high * cars * cars; //Maximum Time is calculated when the machanic with lowest car is given all the work
        // Time=rank * n*n
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (Time(ranks, mid, cars)) {
                ans = mid;
                high = mid - 1;//Minimize the Maximum time
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

```
