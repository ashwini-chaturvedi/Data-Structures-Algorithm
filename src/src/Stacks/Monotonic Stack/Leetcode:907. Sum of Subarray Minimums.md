# Most Important and Hard Pattern

```java
class Solution {
    public int[] previousSmallerElements(int[] nums){
        int[] res=new int[nums.length];
        res[0]=-1;
        Stack<Integer>st=new Stack<>();
        st.push(0);

        for(int i=1;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }

            st.push(i);
        }

        return res;
    }
    public int[] nextSmallerElements(int[] nums){
        int[] res=new int[nums.length];
        res[nums.length-1]=nums.length;
        Stack<Integer>st=new Stack<>();
        st.push(nums.length-1);

        for(int i=nums.length-2;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i]=nums.length;//IMPORTANT:Instead of -1 we store n because its index
            }else{
                res[i]=st.peek();
            }

            st.push(i);
        }

        return res;
    }
    public int sumSubarrayMins(int[] nums) {
        long val=0;
        int[] pse=previousSmallerElements(nums);
        int[] nse=nextSmallerElements(nums);

        // print(pse);
        // print(nse);

        for(int i=0;i<nums.length;i++){
            long leftChoice=i-pse[i];
            long rightChoice=nse[i]-i;
            long mul=leftChoice*rightChoice;
            

            val = (val + ((long)nums[i] * mul)) % 1000000007;
        }

        return (int)(val);
    }
}
```
