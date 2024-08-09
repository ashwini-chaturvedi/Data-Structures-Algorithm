package CollectionFrameWork.Queue_Interface;

import java.util.PriorityQueue;

public class PriorityQueue1 {
    public static void main(String[]args){
        PriorityQueue<Integer>pq=new PriorityQueue<>();//it Implements minHeap in background
        for(int i=5;i>=0;i--){
            pq.add(i);
        }
        System.out.println(pq);

    }
}
