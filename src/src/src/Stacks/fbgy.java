package Stacks;
import java.util.*;
public class fbgy {

        public static int[]nextSmaller(int[]nums){
            Stack<Integer>st=new Stack<>();
            int[]res=new int[nums.length];
            res[nums.length-1]=nums.length;
            st.push(nums.length-1);
            for(int i=nums.length-2;i>=0;i--){
                while(!st.empty()&&nums[st.peek()]>=nums[i]){
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
            Stack<Integer>st=new Stack<>();
            int[]res=new int[nums.length];
            res[0]=-1;
            st.push(0);
            for(int i=1;i<nums.length;i++){
                if(!st.empty()&&st.peek()>=nums[i]){
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
        public static int maxArea(int[]nums){
            int []pse=prevSmaller(nums);
            int []nse=nextSmaller(nums);
            int[] width = new int[nums.length];
            for (int i = 0; i < nums.length; i++)
                width[i] = nse[i] - pse[i] - 1;
            int maxArea=Integer.MIN_VALUE;

            for(int i=0;i<nums.length;i++){
                int area=nums[i]*width[i];
                maxArea=Math.max(maxArea,area);
            }
            return maxArea;
        }
        public static int maximalRectangle(char[][] matrix) {
            int []res=new int[matrix[0].length];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    int ascii=(int)matrix[i][j];
                    res[j]+=(ascii-48);
                }
            }
            int maxA=maxArea(res);

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == '0')
                        res[j] = 0;
                    else
                        res[j] += 1;
                }
                maxA = Math.max(maxA, maxArea(res));
            }


            return maxA;

        }
        public static void main(String[]args){
            char[][] input = {
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
            };
            System.out.println(maximalRectangle(input));


        }

}
