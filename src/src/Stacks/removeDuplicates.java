package Stacks;

import java.util.Stack;

public class removeDuplicates {
    public static int[] remove(int[]arr){
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.empty()||st.peek()!=arr[i]){
                st.push(arr[i]);
            }
            else if(st.peek()==arr[i]){
                if(i==arr.length-1||arr[i]!=arr[i+1]){
                    st.pop();
                }
            }
        }
        int[]res=new int[st.size()];
        for(int j=st.size()-1;j>=0;j--){
            res[j]=st.pop();
        }
        return res;
    }
    public static void main(String[]args){
        int[]arr={1,2,2,3,10,10,10,4,4,4,5,7,7,2};
       int []nums= remove(arr);
       for(int num:nums){
           System.out.print(num+",");
       }
    }
}
