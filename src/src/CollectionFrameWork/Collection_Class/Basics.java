package CollectionFrameWork.Collection_Class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Basics {
    public static void main(String[]args){
        ArrayList<Integer>list=new ArrayList<>();
        list.add(90);
        list.add(0);
        list.add(50);
        list.add(230);
        list.add(230);list.add(230);list.add(230);
        list.add(230);




        System.out.println("Min:"+ Collections.min(list));
        System.out.println("Max:"+ Collections.max(list));
        System.out.println(Collections.frequency(list,230));
        Collections.sort(list);//Ascending Order
        System.out.println(list);
        Collections.sort(list, Comparator.reverseOrder());//Descending Order
        System.out.println(list);

    }
}
