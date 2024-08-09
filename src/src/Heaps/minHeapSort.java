package Heaps;

import java.util.PriorityQueue;

public class minHeapSort {
    public static void main(String[]args){
        int[] arr={8,6,3,10,5,4,9};
        for(int num:arr){
            System.out.print(num+",");
        }
        System.out.println();
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
