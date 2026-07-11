You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be in full bloom from starti to endi (inclusive). You are also given a 0-indexed integer array people of size n, where people[i] is the time that the ith person will arrive to see the flowers.

Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom when the ith person arrives.

 

Example 1:


Input: flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]

![](https://assets.leetcode.com/uploads/2022/03/02/ex1new.jpg)

Output: [1,2,2,2]

# Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.


Mapping the compressed index of people matlab sirf utna hi ka count store krenge jitne ka people index me manga h usse jyada ka nhi 
0=>start,1=>peopleIndex,2=>end
lineSweep[0][0][i]=here we will store the index of last found people seeing taaki query ke time me turant people mile to abhi tkk bloom hua sara flower usko dikha de.
Merge everything {start,people,end}.

## Steps:
  1. Merge Everything {start,people,end}
  2. sort them according to there start time and there types means start comes before people and people comes before end.
  3. traverse the whole merged matrix.        
  

```java
class Solution {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[][] lineSweep = new int[flowers.length * 2 + people.length][3];
        int k = 0;
        int max = Integer.MIN_VALUE;
        for (int[] flower : flowers) {
            int start = flower[0];
            int end = flower[1];

            lineSweep[k++] = new int[] { start, 0, -1 };
            lineSweep[k++] = new int[] { end, 2, -1 };
        }

        for (int i = 0; i < people.length; i++) {
            lineSweep[k++] = new int[] { people[i], 1, i };
        }

        Arrays.sort(lineSweep, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int bloomCount = 0;

        int[] res = new int[people.length];

        for (int[] line : lineSweep) {
            if (line[1] == 0) {//if starting then increase the bloom count.
                bloomCount++;
            } else if (line[1] == 1) {//if people is here then store it in it's answer
                res[line[2]] = bloomCount;
            } else if (line[1] == 2) {//if end then decrease bloom count.
                bloomCount--;
            }
        }

        return res;
    }
}

```
