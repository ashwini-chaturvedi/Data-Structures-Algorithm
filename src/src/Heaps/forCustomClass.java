package Heaps;

import java.util.PriorityQueue;

class tuple{
    int data;
    String s;
    tuple(int key,String s){
        this.data=key;
        this.s=s;
    }
}
public class forCustomClass {
    public static void main(String[]args){
        PriorityQueue<tuple>minHeap=new PriorityQueue<>((a,b)->a.data-b.data);//Comaparator which makes the PriorityQueue a
        //minHeap on the basis of the data
        minHeap.add(new tuple(0,"A"));
        minHeap.add(new tuple(2,"B"));
        minHeap.add(new tuple(3,"C"));
        minHeap.add(new tuple(5,"E"));
        minHeap.add(new tuple(4,"D"));
        System.out.println(minHeap.peek().data+"-"+minHeap.peek().s);


        PriorityQueue<tuple>maxHeap=new PriorityQueue<>((a,b)->b.data-a.data);//Comaparator which makes the PriorityQueue a
        //maxHeap on the basis of the data
        maxHeap.add(new tuple(0,"A"));
        maxHeap.add(new tuple(2,"B"));
        maxHeap.add(new tuple(3,"C"));
        maxHeap.add(new tuple(5,"E"));
        maxHeap.add(new tuple(4,"D"));
        System.out.println(maxHeap.peek().data+"-"+maxHeap.peek().s);
    }
}
