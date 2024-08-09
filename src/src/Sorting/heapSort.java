package Sorting;

import java.util.PriorityQueue;

public class heapSort {
    public static void main(String[]args){
        int[] arr={8,6,3,10,5,4,9};
        System.out.println("Original:");
        for(int num:arr){
            System.out.print(num+",");
        }
        System.out.println();

        //using MaxHeap
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a, b)->b-a);
        for(int num:arr){
            maxHeap.add(num);
        }
        for(int i=arr.length-1;i>=0;i--){
            System.out.print(" Removed:"+maxHeap.peek());
            arr[i]=maxHeap.remove();
        }
        System.out.println();
        for(int num:arr){
            System.out.print(num+",");
        }
        System.out.println();

        //using minHeap

        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int num:arr){
            minHeap.add(num);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(" Removed:"+minHeap.peek());
            arr[i]=minHeap.remove();
        }
        System.out.println();
        for(int num:arr){
            System.out.print(num+",");
        }
    }
}
