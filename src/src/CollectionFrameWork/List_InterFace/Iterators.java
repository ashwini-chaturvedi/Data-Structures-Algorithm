package CollectionFrameWork.List_InterFace;
import java.util.*;
public class Iterators {
    public static void main(String[]args){
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(i);
        }
        Iterator<Integer>it= list.iterator();
//        while(it.hasNext()){
//            System.out.print(it.next()+",");
//        }
        //removes the last Element returned by next;

        while(it.hasNext()){
            System.out.print(it.next()+",");it.remove();
        }
        //better Use 'for each' loop instead of Iterators
    }


}
