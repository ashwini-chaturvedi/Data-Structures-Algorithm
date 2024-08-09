package CollectionFrameWork.List_InterFace;
import java.util.ArrayList;
import java.util.List;

public class ArrayLists {
    public static void main(String[]args){
        ArrayList<Integer> list1=new ArrayList<>();
      list1.add(765);
      list1.add(67);
        System.out.println(list1.hashCode());

//Swapping Elements in a list
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.print(list);
        System.out.println();
        int temp=list.get(0);
        list.set(0,list.get(1));
        list.set(1,temp);
        System.out.print(list);

    }
}
