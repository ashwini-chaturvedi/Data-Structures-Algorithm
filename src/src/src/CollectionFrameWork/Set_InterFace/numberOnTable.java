package CollectionFrameWork.Set_InterFace;

import java.util.HashSet;
import java.util.Set;

public class numberOnTable {
    public static void main(String[]args){
        int []nums={1,1};
        Set<Integer> set=new HashSet<>();
        int maxLen=0;
        for(int num:nums){
            if(!set.contains(num)){
                set.add(num);
                maxLen=Math.max(maxLen,set.size());
            }else{
                set.remove(num);
            }
        }
        System.out.println(maxLen);
    }
}
