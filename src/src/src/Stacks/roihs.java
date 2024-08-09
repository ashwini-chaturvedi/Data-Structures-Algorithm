package Stacks;
import java.util.*;
public class roihs {

        public static int[] prevGreater(int []height){
            Stack<Integer>st=new Stack<>();
            int []ans=new int[height.length];
            ans[0]=height[0];
            st.push(height[0]);
            for(int i=1;i<height.length;i++){
                if(!st.empty()&&st.peek()<height[i]){
                    st.pop();
                    st.push(height[i]);
                }
                if(st.empty()){
                    ans[i]=height[i];
                }else{
                    ans[i]=st.peek();
                }

            }
            ans[height.length-1]=ans[height.length-2];
            return ans;
        }
        public static int[]nextGreater(int []height){
            int[]ans=new int[height.length];
            Stack<Integer>st=new Stack<>();
            ans[height.length-1]=height[height.length-1];
            st.push(height[height.length-1]);
            for(int i=height.length-2;i>=0;i--){
                if(!st.empty()&&st.peek()<height[i]){
                    st.pop();
                    st.push(height[i]);
                }
                if(st.empty()){
                    ans[i]=height[i];
                }else{
                    ans[i]=st.peek();
                }

            }
            return ans;
        }
        public static int trap(int[] height) {
            int []prev=prevGreater(height);
            int []next=nextGreater(height);
            int wi=0;
            for(int i=0;i<height.length-1;i++){
                wi+=Math.min(prev[i],next[i])-height[i];
            }
            return wi;
        }
        public static void main(String[]args){
            int []height={4,2,0,3,2,5};
            int []res1=prevGreater(height);
            int []res2=nextGreater(height);
            for(int num:res1){
                System.out.print(num+" ");
            }
            System.out.println("\n");
            for(int num:res2){
                System.out.print(num+" ");
            }
            System.out.println("\n");
            System.out.println("Answer"+trap(height));
        }
}

