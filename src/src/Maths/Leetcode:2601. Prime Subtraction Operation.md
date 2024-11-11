# My Approach:Actually Modifying the value of the Array by doing Operations
  ## Time Complexity:O(N*M^1/2)
```java
class Solution {
//Do the Operation that means Actually Change the elements of the Array nums[i].
    public void doOperation(int[] nums, boolean[] sieve, int idx) {
        for (int i = nums[idx]-1; i >= 0; i--) {

            if (sieve[i]&& (idx == 0 ||nums[idx] - i > nums[idx - 1])) {//if idx is zero then it can be any number we don't have to worry about this one or check the Condition that the Subtraction operation gives result greater then the previous number because we want to have Strictly Increasing array.
                nums[idx] = nums[idx] - i;
                break;
            } 
        }
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) return false;
        }
        return true;
    }
    public int getMaxElement(int[] nums) {
        int maxVal=-1;
        for (int num:nums) {
            maxVal=Math.max(maxVal,num);
        }
        return maxVal;
    }

    public boolean primeSubOperation(int[] nums) {
        int maxVal=getMaxElement(nums);

        //Sieve of Eratosthenes
        boolean[] sieve = new boolean[maxVal+1];
        Arrays.fill(sieve, true);
        sieve[0]=sieve[1]=false;
        for (int i = 2; i <= Math.sqrt(maxVal); i++) {
            if (sieve[i]) {
                for (int p = i * i; p <= maxVal; p += i) {
                    sieve[p] = false;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            doOperation(nums, sieve, i);//Do in the Following Operation on the array Elements.
        }
        return isSorted(nums);
    }
}
```

# Just calculating wheather it is Possible to have a value from the nums[i] which is prime number
```java
class Solution {
    public int getMaxElement(int[]nums){
        int maxVal=-1;
        for(int num:nums){
            maxVal=Math.max(maxVal,num);
        }
        return maxVal;
    }
    public boolean primeSubOperation(int[] nums) {
        int maxVal=getMaxElement(nums);//this will be the size of the sieve array.

        //Applying Sieve of Eratosthenes...
        boolean[] sieve = new boolean[maxVal+1];
        Arrays.fill(sieve, true);
        sieve[0]=sieve[1]=false;
        for (int i = 2; i <= Math.sqrt(maxVal); i++) {
            if (sieve[i]) {
                for (int p = i * i; p <= maxVal; p += i) {
                    sieve[p] = false;
                }
            }
        }
        int currValue=1;
        int i=0;

        while (i < nums.length) {
             int difference = nums[i] - currValue;//Minus from the Element 
            if (difference < 0) return false;//Means the currValue which is a counter has gone up the actual nums[i] and now we cannot sort the array by doing operations.
            if (sieve[difference] || difference == 0) {//if it is Possible then only move forward
                i++;
                currValue++;
            } else {
                currValue++;
            }
        }
        return true;   
    }
}

```
