package Stacks;

import java.util.Stack;

public class nextSmallerElement {
    public static int[]nextSmaller(int[]nums){
        int []res=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        res[nums.length-1]=-1;
        st.push(nums.length-1);
        for(int i=nums.length-2;i>=0;i--){
            while(!st.empty()&&nums[st.peek()]> nums[i]){
                st.pop();
            }
            if(st.empty()){
                res[i]=-1;
            }else{
                res[i]=nums[st.peek()];
            }
            st.push(i);
        }
        return res;

    }
    public static int[]prevSmaller(int[]nums){
        int[]res=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        res[0]=-1;
        st.push(0);
        for(int i=1;i<nums.length;i++){
            while(!st.empty()&&nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.empty()){
                res[i]=-1;
            }else{
                res[i]=nums[st.peek()];
            }
            st.push(i);
        }
        return res;
    }

    public static void display(int[]nums){
        System.out.print("[");
        for(int num:nums){
            System.out.print(num+",");
        }
        System.out.print("]");
    }
    public static void main(String[]args){
        int[]nums={2,1,5,6,2,3};
        int[]res=nextSmaller(nums);
        display(res);
        System.out.println();
        int []result=prevSmaller(nums);
        display(result);
        System.out.println();


    }
}
