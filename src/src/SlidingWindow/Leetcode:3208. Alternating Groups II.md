There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:

colors[i] == 0 means that tile i is red.
colors[i] == 1 means that tile i is blue.
An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).

Return the number of alternating groups.

Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.

Input: colors = [0,1,0,0,1,0,1], k = 6

Output: 2

Explanation:
![img](https://assets.leetcode.com/uploads/2024/06/19/screenshot-2024-05-28-183907.png)
Alternating groups:
![img](https://assets.leetcode.com/uploads/2024/06/19/screenshot-2024-05-28-184128.png)
![img](https://assets.leetcode.com/uploads/2024/06/19/screenshot-2024-05-28-184240.png)

```java
class Solution {
    /*When there is Circular Array in the Question
    1.Append the array 2nd time into the existing array means 1st array me 2nd time append krdo taaki rotation na krna pde circular array types*/

    public int numberOfAlternatingGroups(int[] colors, int k) {
        List<Integer> list = new ArrayList<>();

        //Add all the elements into the list
        for (int color : colors) {
            list.add(color);
        }
        //*****************************************Important************************************/
        //add the k-1 elements into the list because then the last element will be in the window where 1 element is last element and k-1 elements are from rotated.
        for (int i = 0; i < k - 1; i++) {
            list.add(colors[i]);
        }

        int n = list.size();
        int i = 0;
        int j = 1;
        int count = 0;

        while (j < n) {
            if (list.get(j) == list.get(j - 1)) { //if the adjacent colors are same
                i = j; //short the Window
                j++; //Move the Window
                continue;
            }
            if ((j - i + 1) == k) {//Window size is Equal to 'k'
                count++;
                i++;
            }
            j++;
        }

        return count;
    }
}

```
