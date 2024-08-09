package CollectionFrameWork.Queue_Interface;

import java.util.*;
import java.util.Queue;

public class LinkedList_Queue {
    public static void main(String[]args){
        List<Integer>list1=new LinkedList<>();//List Interface is Implemented
        list1.add(834);
        LinkedList<Integer>ll=new LinkedList<>();
        ll.add(48609);
        Queue<Integer>q=new LinkedList<>();//Queue Interface is being implemented by LinkedList class
        q.add(49);//adds the value inside the queue and return, if operation fails it throws Exception
        q.offer(8);//adds the value inside the queue and returns true if operation fails it returns false

        //For obtaining the element at Front of queue
        q.peek();//
        q.element();//if operation fails it throws Exception


        //for Removing the element at front
        q.remove();//if operation fails it throws Exception
        q.poll();//
        q.add(949);
        q.add(4367);
        for(int num:q){
            System.out.println(num);
        }
    }
}
