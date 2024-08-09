package Recursion.Recursion;



/*There are N stones, numbered 0,1,2,.. .,N-I. For each i (0<=i<N), the height of Stone i is hi. There is a
frog who is initially on Stone 0. He will repeat the following action some number of times to reach
Stone N-1:
1.If the frog is currently on Stone i, he can jump to Stone i+1 or Stone i+2.
2.Here, a cost of |hi - hj|  is incurred, where j is the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone N.

Input n=4
[]arr=10,30,40,20
Output= 30
*/
public class FrogProblem {
    public static int frogJump(int[]height,int idx,int arraySize){
        if(idx==arraySize-1){
            return 0;//we are at last stone and there will be no cost from it.
        }

        //to get the absolute value we will use Maths.abs() function.
        int op1=Math.abs(height[idx]-height[idx+1])+frogJump(height,idx+1,arraySize);
        if(idx==arraySize-2){//means you are at index just before the last index and there is no i+2 stone so return from it.
            return op1;        }
        int op2=Math.abs(height[idx]-height[idx+2])+frogJump(height,idx+2,arraySize);

        return Math.min(op1,op2);
    }
    public static void main(String[]args){

        int[]nums={10,100,400,20};
        System.out.println("Minimum Cost is:"+frogJump(nums,0,nums.length));


    }
}
