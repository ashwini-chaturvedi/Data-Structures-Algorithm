```java
class Solution {
//Bubble Sort with a Special Condition of checking equal number of setbits
    public boolean canSortArray(int[] nums) {
        boolean isSwapped = true;
        for (int i = 0; i < nums.length; i++) {
            isSwapped = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    //# Special condition 
                    if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {//Numbers can be Swapped only when they have equal number of setBits...
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        isSwapped=true;
                    } else {
                        return false;
                    }
                }
            }
            if(!isSwapped) break;
        }

        return true;
    }
}
```
