package Sorting;

public class InsertionSort {
    public static void InsertionSort(int[]nums){
        for(int i=1;i<nums.length;i++){
            int key=nums[i];
            int j=i-1;
            while(j>=0&&nums[j]>key){
                //shifting
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=key;
        }
    }
    public static void InsertionSortmethod2(int[]nums){
        for(int i=1;i<nums.length;i++){
            int j=i;
            while(j>0&&nums[j]<nums[j-1]){
                //swapping
                nums[j]=nums[j]^nums[j-1];
                nums[j-1]=nums[j]^nums[j-1];
                nums[j]=nums[j]^nums[j-1];
                j--;
            }
        }
    }
    public static void main(String[]args){
        int[]arrr={23,46,23,235,56,345};
        System.out.println("Method 1");
        InsertionSort(arrr);
        for(int num:arrr){
            System.out.print(num+",");
        }
        System.out.print("\n");
        System.out.println("Method 2");

        InsertionSortmethod2(arrr);
        for(int num:arrr){
            System.out.print(num+",");
        }

    }
}
