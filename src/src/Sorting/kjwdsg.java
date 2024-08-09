package Sorting;

public class kjwdsg {

    public static void main(String[]args){
        int []nums={34,23,67,8,6,4,8,53,6,32,567};
        System.out.println(nums.length+","+(nums.length-1));
        for(int i=1;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }
        System.out.println("max:"+max);




    }
}
