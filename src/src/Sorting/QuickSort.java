package Sorting;

public class QuickSort {
    static int partition(int []nums,int low,int high){

        int pivot=nums[high];
        System.out.println("Pivot num:"+nums[high]);
        int i=low-1;
        for(int j=low;j<high;j++){
            if(nums[j]<pivot){
                i++;
                //swapping nums[i] & nums[j] so that element smaller than pivot should be on left side of the chosen pivot.
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        //i th Index will be storing the element which is nearest number smaller than pivot element so we swap the element at
        //i+1 th Index with the pivot element.
        //element at high is the pivot element.
        int temp=nums[i+1];
        nums[i+1]=nums[high];
        nums[high]=temp;
        for(int num:nums){
            System.out.print(num+"   ");
        }
        return i+1;//Index of pivot element.
    }

    static void quicksort(int []nums,int Fidx,int Lidx){
        if(Fidx>=Lidx){
            return;
        }
        int pivot=partition(nums,Fidx,Lidx);
        quicksort(nums,Fidx,pivot-1);
        quicksort(nums,pivot+1,Lidx);

    }
    public static void main(String[]args){
        int []arr={34,23,67,567,8,6,4,8,53,6,32};
        System.out.print("Unsorted Array:\n");
        for(int num:arr){
            System.out.print(num+",");
        }
        quicksort(arr,0,arr.length-1);
        System.out.println("Sorted Array:");
        for(int num:arr){
            System.out.print(num+",");
        }

    }
}
