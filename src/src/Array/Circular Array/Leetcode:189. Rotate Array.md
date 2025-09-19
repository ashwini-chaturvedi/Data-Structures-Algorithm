# In-Place
```java
class Solution {
    public void reverse(int[] nums,int low,int high){
        while(low<high){
            nums[low]=nums[low]^nums[high];
            nums[high]=nums[low]^nums[high];
            nums[low]=nums[low]^nums[high];

            low++;
            high--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle cases where k >= n
        
        // Step 1: Reverse the whole array
        reverse(nums, 0, n - 1);
        
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Step 3: Reverse the remaining n - k elements
        reverse(nums, k, n - 1);
    }
}
```

# Using New Array
```java
class Solution {
    public void rotate(int[] nums, int k) {
        int[] rotate=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            rotate[(i+k)%nums.length]=nums[i]; //This will Actually Rotate the Array 
            //here we are adjusting the Index on the terms of fitting the elements at right spot...
        }
       
        for(int i=0;i<nums.length;i++){
            nums[i]=rotate[i];
        }
        
    }
}
```
