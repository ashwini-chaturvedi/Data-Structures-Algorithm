package Heaps;

import java.util.PriorityQueue;

public class minHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();//No Comparator is Needed as PriorityQueue is itself a minHeap
        minHeap.add(8);
        minHeap.add(6);
        minHeap.add(3);
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(4);
        minHeap.add(9);
        System.out.println(minHeap.remove());
        System.out.println();
        for(int num:minHeap){
            System.out.println(num);
        }

    }
}
