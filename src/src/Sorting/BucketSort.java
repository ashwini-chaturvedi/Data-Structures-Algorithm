package Sorting;
import java.util.*;

public class BucketSort {
    static void bucketSort(float []nums){
        ArrayList<Float>[]buckets=new ArrayList[nums.length];//Float type ArrayList.
        //create empty buckets
        for(int i=0;i<nums.length;i++){
            buckets[i]=new ArrayList<Float>();
        }
        //Adding
        for(int i=0;i<nums.length;i++){
            int idx=(int)(nums[i]*(nums.length-1));//finding the index to insert the value
            buckets[idx].add(nums[i]);
        }
        //Sorting Individual bucket
        for(int i=0;i<nums.length;i++){
            Collections.sort(buckets[i]);//Inbuilt function.//Using Quick Sort //O(nlogn) time complexity.
        }
        //Combining the buckets
        int k=0;
        for(int i=0;i<buckets.length;i++){
            ArrayList<Float> currBucket=buckets[i];
            for(int j=0;j<currBucket.size();j++){
                nums[k++]=currBucket.get(j);
            }
        }


    }
    public static void main(String[]args){
        float []arr={0.34f,0.23f,0.67f,0.567f,0.8f,0.6f,0.4f,0.8f,0.53f,0.6f,0.32f};
        System.out.print("Unsorted Array:\n");
        for(float num:arr){
            System.out.print(num+",");
        }
        bucketSort(arr);
        System.out.println("\nSorted Array:");

        for(float num:arr){
            System.out.print(num+",");
        }
    }
}
