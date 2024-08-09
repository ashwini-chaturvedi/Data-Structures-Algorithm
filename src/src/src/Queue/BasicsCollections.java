package Queue;

import java.util.*;

public class BasicsCollections {
    public static void main(String[]args){
        Queue<Integer>queue=new LinkedList<>();//this shows that it is the Linked List Implementation of Queue
        Queue<Integer>q=new ArrayDeque<>();//Implementing queue using Array double ended queue class...
        System.out.println(queue.isEmpty());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(5);
        queue.add(7);
        queue.add(9);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue);


        queue.poll();//it removes the element from front same as remove() but it doesnt return the value...
        System.out.println(queue);
        System.out.println(queue.element());// it gives the element at front same as peek();
        Queue<Integer>res=new LinkedList<>();
        while(!queue.isEmpty()){
            int a=queue.remove();
            System.out.print(a+",");
            res.add(a);//so that the elements doesnt get lost
        }
        System.out.println();
        System.out.println(res);




    }
}
