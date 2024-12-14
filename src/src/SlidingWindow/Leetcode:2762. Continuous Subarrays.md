```java
class Solution {
//We can re structure the question as the maximum diff cannot exceed 2.
    public long continuousSubarrays(int[] nums) {
        long count = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>(); //Tree Map to get the maximum and minimum value at instant

//Sliding Window
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);//Increase the count of the element

            while (i <= j && map.lastKey() - map.firstKey() > 2) {////Shrink the window
                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) map.remove(nums[i]);//remove the value

                i++;
            }
            count += j - i + 1;//total number of subarrays is equal to size of the window because the elements in between the window will also justify the condition
            j++;
        }
        return count;
    }
}

```
