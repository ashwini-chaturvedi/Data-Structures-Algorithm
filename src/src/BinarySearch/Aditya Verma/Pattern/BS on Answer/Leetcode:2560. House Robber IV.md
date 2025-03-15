There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.

The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.

You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.

You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.

Return the minimum capability of the robber out of all the possible ways to steal at least k houses.

 

Example 1:

Input: nums = [2,3,5,9], k = 2
Output: 5
Explanation: 
There are three ways to rob at least 2 houses:
- Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
- Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
- Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
Therefore, we return min(5, 9, 9) = 5.

```java
class Solution {

    /*Use a check function to determine if it is possible to select k non-consecutive elements that are less than or equal to the current "guess" value.*/
    public boolean canBeRobbed(int[] nums, int guess, int k) {
        int house=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<=guess){//less than or equal to the current "guess" value
                house++;//robbed this house
                i++;//Skip the neighbouring house and move to next house
            }
        }

        return house>=k;//house greater than equal to k
    }

    public int minCapability(int[] nums, int k) {
        //isme total nhi nikalenge kyuki isme kch jgh ki chize li jaskti h aur kch jgh ki nhi (adjacent houses cannot be robbed) aur hm minimum aur maximum ke bich choose krte jaenge kya iss number se 'k' number of houses robb hoskte h itne capability score pe.
        //agar milgya toh hm search space ko short krte rhenge jbtk shortest point na miljaaye
    
        int low = Integer.MAX_VALUE;
        int high = 0;
        for (int num : nums) {//Total capability 
            low=Math.min(num,low);
            high=Math.max(num,high);
        }

        int res = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canBeRobbed(nums, mid, k)) {
                res = mid;
                high = mid - 1;//to minimize the maximum capability gained by robbing 
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
```
