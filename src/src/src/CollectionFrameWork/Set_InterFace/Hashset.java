package CollectionFrameWork.Set_InterFace;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Hashset {
    public static void main(String[]args){
        //duplicate elements are not Allowed in set...IMPORTANT///
        Set<Integer> hash=new HashSet<>();//Set InterFace Implemented by HashSet Class of Java Collection FrameWork
        // there is no order in set elements are added arbitrarly and recieved out in any order...




//        for(int i=0;i<6;i++){
//            hash.add(i);
//        }
//        System.out.println(hash);
        hash.add(2);//O(1) time
        hash.add(24);
        hash.add(22);
        hash.add(234);
        hash.add(8);
        hash.add(90);



        System.out.println(hash);

        hash.remove(234);
        System.out.println(hash);

        System.out.println(hash.contains(9));//checks if the Element is Present or not

        System.out.println(hash.isEmpty());

        System.out.println(hash.size());

//       hash.clear();
        System.out.println(hash.isEmpty());

        //we can traverse a set simply using the for each loop there is no need of entrySet() like map
        System.out.println("8");
        for(Integer i:hash){
            System.out.print(i+",");
        }

//        String []ans={"0201","0101","0102","1212","2002"};
//        Set<String> hash1 = new HashSet<>(Arrays.asList(ans));
//       for(var node:hash1){
//           System.out.println(node);
//       }
//        System.out.println(hash1.contains("0201"));


    }
}
