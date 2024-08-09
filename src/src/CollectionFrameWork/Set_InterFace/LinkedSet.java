package CollectionFrameWork.Set_InterFace;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedSet {
    public static void main(String[]args){
        Set<Integer> LinkedHash=new LinkedHashSet<>();// Set Interface is Implemented by LinkedHashSet class now all the elements are
        // stored in a structural order one by one order...

        LinkedHash.add(2);
        LinkedHash.add(24);
        LinkedHash.add(22);
        LinkedHash.add(234);
        LinkedHash.add(8);
        LinkedHash.add(90);

        System.out.println("Linked Hash Set:"+LinkedHash);

        LinkedHash.remove(234);
        System.out.println(LinkedHash);

        System.out.println(LinkedHash.contains(9));//checks if the Element is Present or not

        System.out.println(LinkedHash.isEmpty());

        System.out.println(LinkedHash.size());

        LinkedHash.clear();
        System.out.println(LinkedHash.isEmpty());
    }
}
