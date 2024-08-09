package Stacks;


import java.util.Stack;

public class nextGreaterElement {
    public static int[]prevGreater(int[]nums){
        int[]ans=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        ans[0]=1;//there is no previous element to the 1st element.
        //this means span value of the first element is always 1...
        st.push(0);//Instead of pushing values into the stack we will push the indices which will help to maintain the count
        for(int i=1;i<nums.length;i++){
            while(!st.empty()&&nums[st.peek()]<=nums[i]){
                st.pop();
            }
            /*If stack becomes empty, then price[i] is
            // greater than all elements on left of it,
            // i.e., price[0], price[1], ..price[i-1]. Else
            // price[i] is greater than elements after top
             of stack*/
            if(st.empty()){
                ans[i]=i+1;
            }else{
                ans[i]=i-st.peek();
            }
             st.push(i);
        }
        return ans;
    }
    public static int[]prevGreaterElement(int[]nums){
        int[]ans=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        ans[0]=-1;//there is no previous element to the 1st element.
        //this means span value of the first element is always 1...
        st.push(nums[0]);//Instead of pushing values into the stack we will push the indices which will help to maintain the count
        for(int i=1;i<nums.length;i++){
            while(!st.empty()&&st.peek()<nums[i]){
                st.pop();
            }
            /*If stack becomes empty, then price[i] is
            // greater than all elements on left of it,
            // i.e., price[0], price[1], ..price[i-1]. Else
            // price[i] is greater than elements after top
             of stack*/
            if(st.empty()){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }
    public static int[] nextGreaterFromFront(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        // Initialize the stack with the index of the first element
        st.push(0);
        res[0] = -1; // There's no next greater element for the first element

        for (int i = 1; i < nums.length; i++) {
            // While the stack is not empty and the current element is greater than the element at the index on top of the stack
            while (!st.empty() && nums[st.peek()] < nums[i]) {
                res[st.pop()] = nums[i]; // Update the result for the index on top of the stack
            }

            // Push the current index onto the stack
            st.push(i);

            // Initialize the result for the current index as -1
            res[i] = -1;
        }

        return res;
    }

    public static int[]nextGreater(int[]nums){
        /* =>Approach<=
           pop
           calculate ANS
           push
         */
        int[]res=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        res[nums.length-1]=-1;//because next to the last digit the array ends and there is no next greater element so we will put -1
        st.push(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--){
            while(!st.empty()&&st.peek()<nums[i]){
                st.pop();
            }
            if(st.empty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }
            st.push(nums[i]);
        }
        return res;
    }
    public static void main(String[]args){
        int[]nums={1,5,3,2,1,6,3,4};
//        int[]res=nextGreater(nums);
//        for(int nm:res){
//            System.out.print(nm+",");
//        }
        int []ans={100,80,60,70,60,75,85};
        int []result=prevGreater(ans);
        for(int num:result){
            System.out.print(num+",");
        }
        System.out.println();
//        int[]nums=nextGreaterFromFront(num);
//        for(int nu:nums){
//            System.out.print(nu+",");
//        }
        int []h={0,1,0,2,1,0,1,3,2,1,2,1};
        int []res=prevGreaterElement(h);
        for(int num:res){
            System.out.print(num+",");
        }
        System.out.println();
        int[]re=nextGreater(h);
        for(int nu:re){
            System.out.print(nu+",");
        }

    }
}
