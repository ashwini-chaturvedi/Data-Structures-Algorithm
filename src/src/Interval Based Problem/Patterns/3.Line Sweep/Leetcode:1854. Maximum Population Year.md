You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.

 

Example 1:

Input: logs = [[1993,1999],[2000,2010]]

Output: 1993

Explanation: The maximum population is 1, and 1993 is the earliest year with this population.

```java
class Solution {

    public int maximumPopulation(int[][] logs) {
        int[][] lineSweeps = new int[logs.length * 2][2];

        int i = 0;
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];

            lineSweeps[i++] = new int[] { birth, 1 };
            lineSweeps[i++] = new int[] { death, -1 };
        }

        Arrays.sort(lineSweeps, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        
        int count = 0;
        int maxCount = 0;
        int year = 0;

        for (int[] line : lineSweeps) {
            int event = line[0];
            int delta = line[1];

            count += delta;

            if (count > maxCount) {
                year = event;
                maxCount = count;
            }
        }

        return year;
    }
}

```
