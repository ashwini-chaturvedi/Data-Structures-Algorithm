package Array;

import java.util.Scanner;

public class Search_in_RotatedArray {
        public static int search(int[] nums, int target) {
            int low=0;
            int high=nums.length-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[low]<=nums[mid])//This else if statement checks if the left half of the subarray (from low to mid) is sorted.
                // It does this by comparing the element at index low with the element at index mid.
                {
                    if(nums[low]<=target&&nums[mid]>target){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }

                }else{
                    if(nums[high]>=target&&nums[mid]<target){
                        low=mid+1;

                    }
                    else{
                        high=mid-1;
                    }
                }
            }
            return -1;
        }
    public static void takeInput(int[]array){
        System.out.println("Enter the Elements of the array:");
        Scanner Input=new Scanner(System.in);
        for(int i=0;i<array.length;i++){
            array[i]=Input.nextInt();
        }
    }
    public static void printArray(int []array){
        for(int i=0;i<array.length;i++){
            System.out.print(" "+array[i]);
        }
    }
    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);
        System.out.println("Enter the size of Array:");
        int sizeofArray=Input.nextInt();
        int []array=new int[sizeofArray];
        takeInput(array);
        printArray(array);
        System.out.println("\nEnter the Target Element :");
        int num=Input.nextInt();
        int Index=search(array,num);
        System.out.println("The Target Element is Present at:"+Index+" Index");




    }
}
