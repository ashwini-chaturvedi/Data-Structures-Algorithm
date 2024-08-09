package Recursion.Recursion;

import java.util.ArrayList;

public class RecursiveInArray {
    public static void array(int[]nums,int i){
        if(i==nums.length){
            return;
        }
        System.out.print(" "+nums[i]);
        array(nums,i+1);

    }
    public static int maxVal=0;
    public static int printMax(int[] nums,int i){

        if(i==nums.length){
            return maxVal;
        }
        if(maxVal<nums[i]){
            maxVal=nums[i];
        }
        return printMax(nums,i+1);

    }
    public static int sum=0;
    public static int sumOfElements(int []nums,int idx){
        if(idx==nums.length){
            return sum;
        }
        sum+=nums[idx];
        return sumOfElements(nums,idx+1);
    }
    public static boolean flag=false;
    public static boolean findTarget(int[]nums,int idx,int target){
        if(idx==nums.length){
            return flag;
        }
        if(nums[idx]==target){
            flag=true;
        }
        return findTarget(nums,idx+1,target);
    }
    public static void printIndex(int[]nums,int idx,int target){
        if(idx==nums.length){
            return ;
        }
        if(nums[idx]==target){
           System.out.print(idx);
        }
       printIndex(nums,idx+1,target);


    }
    public static ArrayList<Integer>arrayOfIdx(int []nums, int idx, int target, ArrayList<Integer> res){
        if(idx==nums.length){
            return res;
        }
        if(nums[idx]==target){
            res.add(idx);
        }
        return arrayOfIdx(nums,idx+1,target,res);

    }
    public static void main(String[]args){
        int[] nums={1,2,3,3,3,6,848,8,3};
        array(nums,0);
        int maxVal=printMax(nums,0);
        System.out.println("\nMax Value:"+maxVal);

        System.out.println("\nSum of the Elements:"+sum);
        sumOfElements(nums,0);
        System.out.println("\nSum of the Elements:"+sum);
        int target=3;

        System.out.println("\nTarget Element is present:"+findTarget(nums,0,target));
        ArrayList<Integer> res=new ArrayList<>();

        System.out.println("\nTarget Element is present at following Indexes:"+arrayOfIdx(nums,0,target,res));

        printIndex(nums,0,target);


    }
}
