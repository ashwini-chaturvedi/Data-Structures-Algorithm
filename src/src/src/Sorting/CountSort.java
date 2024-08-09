package Sorting;

public class CountSort {
    static void countSort(int[]nums){
        //finding maximum element
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
       // Frequency Array
        int []freq=new int[max+1];
        for(int num:nums){
            freq[num]++;
        }
        //prefix sum of freq array
        for(int i=1;i<=freq.length-1;i++){
            freq[i]+=freq[i-1];
        }
        int []output=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            //getting the Index of the elements
//            int idx=freq[nums[i]];//this wil give the frequency wise index starting from 1
            int idx=freq[nums[i]]-1;
            output[idx]=nums[i];
            freq[nums[i]]--;//making the fequency count of the element decrease by 1
        }

        for(int i=0;i<nums.length;i++){
            nums[i]=output[i];
        }
    }
    public static void main(String[]args){
        int []arr={34,23,67,567,8,6,4,8,53,6,32};
        System.out.print("Unsorted Array:\n");
        for(int num:arr){
            System.out.print(num+",");
        }
        countSort(arr);
        System.out.println("\nSorted Array:");

        for(int num:arr){
            System.out.print(num+",");
        }
    }
}
