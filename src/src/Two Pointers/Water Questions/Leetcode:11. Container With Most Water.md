You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:

![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg)

Input: height = [1,8,6,2,5,4,8,3,7]

Output: 49

Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

```java
class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (left <= right) {
            int l = Math.min(height[left], height[right]);
            int b = right - left ;

            maxArea = Math.max(maxArea, l * b);

            //Try to use two-pointers. Set one pointer to the left and one to the right of the array. Always move the pointer that points to the lower line.
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

```
