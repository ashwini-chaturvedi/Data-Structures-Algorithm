package CollectionFrameWork.Queue_Interface;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDEque {
    public static void main(String[]args){
        Queue<Integer> adq=new ArrayDeque<>();//Double Ended Queue
        adq.add(49);
        adq.add(88);

        System.out.println(adq.equals(49));

    }
}
