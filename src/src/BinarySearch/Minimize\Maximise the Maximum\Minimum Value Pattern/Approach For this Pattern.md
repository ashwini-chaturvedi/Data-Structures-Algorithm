```java
0. There is a Key Word or Sensation of either maximising the minimum value or minimising the maximum value.
      e.g.:Leetcode:1760.This question has "Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations".
1. We will generally apply Binary Search Between 1 and Maximum value Present in the Array.
2. Then,We will check if that mid element is Valid for the Answer
3. if we have to find the number Question has Asked
      i) Maximize the Minimum Value:So we will go towards the Maximum number: low=mid+1
      ii) Minimize the Maximum Value:So we will go towards the Minimum number: high=mid-1
          
```
# General Format
- Minimize the Maximum Value
```java
public int minimizeTheMaximum(int[] nums, int maxOperations) {
        int maxVal = -1;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int low = 1; //Best case secenario 
        int high = maxVal; //Worst case scenario 

        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isDivisble(nums,mid)) {//this method is different according to the Question which we have to find.
                res = mid;
                high = mid - 1; //Minimize the Maximum Value
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
```

- Maximize the Minimum Value
```java
public int minimizeTheMaximum(int[] nums, int maxOperations) {
        int maxVal = -1;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int low = 1; //Best case secenario 
        int high = maxVal; //Worst case scenario 

        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(nums,mid)) { //this method is different according to the Question which we have to find.
                res=mid;
                low = mid + 1; //Maximize the minimum value
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
```
