Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]

![img](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)

Output: 6

Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

# Two Pointer Approach.
```java
class Solution {
    public int trap(int[] height) {
        //Two Pointer Approach.
        int low=0;
        int high=height.length-1;

        int leftMax=Integer.MIN_VALUE;
        int rightMax=Integer.MIN_VALUE;

        int totalWater=0;

        while(low<high){
            //get the maximum in the left and right it will help us to find which way & how much the water will be stored.
            leftMax=Math.max(leftMax,height[low]);
            rightMax=Math.max(rightMax,height[high]);

            //if leftMax is Small then water will be stored in left side 
            if(leftMax<rightMax){//jidhar chota h udhar hi pani store hopaega

                totalWater+=(leftMax-height[low]);//amount of water trapped 
                low++;//move to increase the left side
            }else{
                totalWater+=(rightMax-height[high]);//amount of water trapped 
                high--;
            }
        }

        return totalWater;
    }
}
```

# modified Monotonic-Stack Based Approach
```java
class Solution {
    public int[] prevGreaterElements(int[] height){
        int[] ans=new int[height.length];
        Stack<Integer>st=new Stack<>();

        ans[0]=height[0];
        st.push(height[0]);

        for(int i=1;i<height.length;i++){
            if(!st.isEmpty() && st.peek()<height[i]){//Because we are Finding greater element so stack should be monotonic
                st.pop();
                st.push(height[i]);
            }

            if(!st.isEmpty()){
                ans[i]=st.peek();
            }
        }

        return ans;
    }

    public int[] nextGreaterElements(int[] height){
        int[] ans=new int[height.length];
        Stack<Integer>st=new Stack<>();

        st.push(height[height.length-1]);
        ans[height.length-1]=height[height.length-1];

        for(int i=height.length-2;i>=0;i--){
            if(!st.isEmpty() && st.peek()<height[i]){
                st.pop();
                st.push(height[i]);
            }

            if(!st.isEmpty()) ans[i]=st.peek();
        }

        return ans;

    }
    public int trap(int[] height) {
        if(height.length<=1) return 0;

        //Ek Point pe kitna water store hoskta h iska pta nextGreater and prevGreater height me se minimum jo hoga usko leke aur current building ki height se minus krke pta lgega e.g currentHeight is 1 and prevGreater is 1 and next is 1 so left and right boundary toh 1 hi height ki hui aur current building bhi 1 height ki h so water toh store nhi hopaega

        int[] prevGreater=prevGreaterElements(height);
        int[] nextGreater=nextGreaterElements(height);

        int trappedWater=0;

        for(int i=0;i<height.length;i++){
            trappedWater+=Math.min(prevGreater[i],nextGreater[i])-height[i];
        }

        return trappedWater;
    }
} 
```
