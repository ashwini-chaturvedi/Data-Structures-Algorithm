package Recursion;

public class MergeSort {
    public static void merging(int[]nums,int start,int mid,int end){

    }
    public static void mergeSort(int[]nums,int start,int end){
        if(start==end){
            return;
        }
        int mid=start+(end-start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);

        merging(nums,start,mid,end);
    }
    public static void main(String[]args){

    }
}
