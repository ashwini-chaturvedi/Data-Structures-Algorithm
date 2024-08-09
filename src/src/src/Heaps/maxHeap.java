package Heaps;

import java.util.PriorityQueue;

public class maxHeap {
    public static void main(String[]args){
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>((a,b)->b-a);//comparator to change the priorityQueue into maxHeap
        maxHeap.add(8);
        maxHeap.add(6);
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(4);
        maxHeap.add(9);
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.peek());

    }
}
