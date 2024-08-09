package Queue.DEqueue;

import java.util.*;
import java.util.Deque;

public class Basics {
    public static void main(String[]args){
        Deque<Integer>dq=new LinkedList<>();
        dq.addFirst(1);
        dq.addLast(2);
        dq.addLast(4);
        dq.addFirst(3);
        System.out.println(dq);
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq);
        System.out.println( dq.contains(1));
        dq.offer(8);//add the element to the queue from rear side ...
        System.out.println(dq);

    }
}
