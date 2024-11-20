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
