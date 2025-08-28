```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        //Two same elements should be together so i+2 
        while (j < nums.length) {
            if (i<nums.length-2 && j>=i+2 && nums[i] != nums[j]) {//if elements are not same then swap them
                nums[i + 2] = nums[j];
                i++;
            }
            j++;

        }
        return i + 2;
    }
}
```
