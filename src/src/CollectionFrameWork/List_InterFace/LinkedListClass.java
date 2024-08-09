package CollectionFrameWork.List_InterFace;

import java.util.LinkedList;
import java.util.List;

public class LinkedListClass {
    public static void main(String[] args) {
        List<Integer> list1=new LinkedList<>();//List Interface is Implemented
        list1.add(834);
        list1.add(0);
        list1.add(834);
        list1.add(0);
        list1.add(834);
        list1.add(0);


       for(Integer in:list1){
           System.out.println(in);
       }

    }
}
