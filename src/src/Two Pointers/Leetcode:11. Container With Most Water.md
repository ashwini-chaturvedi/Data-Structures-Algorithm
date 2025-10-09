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
