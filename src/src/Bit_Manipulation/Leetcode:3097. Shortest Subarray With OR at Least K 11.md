# longest/shortest + SubArray + with +condition == Sliding Window Technique
```java
class Solution {

    //SubArray + with +condition == Sliding Window Technique

    public void updateInWindow(int num, int[] BitCounts, boolean toAdd) {
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) { //Finding Wheather the ith bit is Set or Not
                if (toAdd) { //true shows that the num is added to the window
                    BitCounts[i]++;
                } else { //false shows that the num is Removes from the window
                    BitCounts[i]--;
                }
            }
        }
    }

    public int getDecimalFromBinary(int[] BitCounts) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (BitCounts[i] > 0) { //means that there is atleast 1 element in the window which has the ith bit set
                ans |= (1 << i); //##Important:it will set the ith bit in the ans that means when there is atleast 1 element in window whose ith bit is set then to get number we will set that bit in another number and eventually we will get the Number.e.g for [1,2,3]=> BitCounts=[2,2,0,... upto 32-1 Index] if we set the bits of 0(0000) according to the Indexes which have value bigger than zero then we will set the 0th,1st bit so 0(0000) becomes 3(0011) which is the OR value of all the Elements in Window
            }
        }
        return ans;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int[] BitCounts = new int[32]; //This array will store the setBits of all the Element inside the Window means wheather ith bit is set in atleast 1 element that is Inside the Window is Stored here.

        //Sliding Window
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;

        while (j < nums.length) {
            updateInWindow(nums[j], BitCounts, true); //if we add an Element in the Window then we will take account its number of setBits ans store it in the BitCounts Array.e.g for [1,2,3]=> BitCounts=[2,2,0,... upto 32-1 Index showing that 2 elements have there 0th bit set and 2 are having 1st bit set and then all bits are not set].true shows that the num is added to the window

            while (i <= j && getDecimalFromBinary(BitCounts) >= k) { //From Binary BitCounts Array we will retrieve the decimal value which shows that this is the current OR value of all the Elements of the Window.
                minLen = Math.min(minLen, j - i + 1); //Calculate the Min Length

                updateInWindow(nums[i], BitCounts, false); //when the Condition is Met we want to minimise or decrease the size of the window for best Possible minimum length. so to do that we start decreasing the size and while doing that the count of the set bits in the removed element is decreased from the BitCounts Array...
                //eg.e.g for [1,2,3]=> BitCounts=[2,2,0,... upto 32-1 Index if 1 is removed then 1 only has 1 set bit at the least significant position so we decrease the count at 0 index.false shows that the num is removed from the window

                i++; //Short the window
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}

```
