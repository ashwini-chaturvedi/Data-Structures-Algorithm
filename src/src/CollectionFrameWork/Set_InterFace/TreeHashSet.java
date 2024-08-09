package CollectionFrameWork.Set_InterFace;

import java.util.Set;
import java.util.TreeSet;

public class TreeHashSet {
    public static void main(String[]args){

        Set<Integer>treeHash=new TreeSet<>();//Set Interface is being Implemented by TreeSet class
        //Now set will have
          // 1.All the Elements Inside will be Unique :Property of Set
          // 2.All the Elements are Stored in a Sorted Order Unlike normal sets  : Property of TreeSet
        treeHash.add(84);//O(log n) time
        treeHash.add(8);
        treeHash.add(5);
        treeHash.add(4);
        treeHash.add(544);
        treeHash.add(8443);
        treeHash.add(85);
        System.out.println(treeHash);


    }
}
