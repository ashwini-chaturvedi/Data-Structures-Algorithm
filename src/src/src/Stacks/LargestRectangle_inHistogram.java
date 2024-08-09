package Stacks;
import java.util.Stack;

public class LargestRectangle_inHistogram {
    public static int[]nextSmallerElement(int[]heights){
        int length=heights.length;
        int []res=new int[length];
        Stack<Integer>st=new Stack<>();
        res[length-1]=length;//next smaller element of last element is always smaller if the array is non cyclic
        st.push(length-1);//pushing the Indexes

        for(int i=length-2;i>=0;i--){
            //starting the loops from second last point of the array
            while(!st.empty()&&heights[st.peek()]>=heights[i]){
                //if the element at index present on top of stack is greater then current element so pop that element to find the smallest number present if so...
                st.pop();
            }
            if(st.empty()){
                res[i]=length;//no next smaller element is present so -1.
            }else{
                res[i]=st.peek();//storing the Index of the next smaller element of that number which is present on heights[i] in res[i];
            }
            st.push(i);
        }
        return res;

    }
    public static int[]prevSmallerElement(int[]heights){
        int length=heights.length;
        int []res=new int[length];
        Stack<Integer>st=new Stack<>();
        res[0]=-1;//previous smaller of the 1st element of a non cyclic array does not exist so -1...
        st.push(0);
        for(int i=1;i<length;i++){
            while(!st.empty()&&heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.empty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;

    }
    public static int maxArea(int[]heights,int[]nse,int[]pse){
        int length=heights.length;
        int maxA=Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            int res=heights[i]*(nse[i]-pse[i]-1);
            maxA=Math.max(maxA,res);
        }
        return maxA;
    }
    public static int largestRectangleArea(int[] heights) {
        int[]NSE=nextSmallerElement(heights);
        int []PSE= prevSmallerElement(heights);
        int maxAreaofRectangle=maxArea(heights,NSE,PSE);
        return maxAreaofRectangle;
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
        int[]res=nextSmallerElement(nums);
        display(res);
        System.out.println();
        int []result=prevSmallerElement(nums);
        display(result);
        System.out.println();

        System.out.println("Area of largest Rectangle:"+largestRectangleArea(nums));

    }
}
