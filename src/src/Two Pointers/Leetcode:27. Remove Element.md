```java
class Solution {
    public int removeElement(int[] nums, int val) {
//Two Pointer
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {

            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }

        return i;
    }
}
```
