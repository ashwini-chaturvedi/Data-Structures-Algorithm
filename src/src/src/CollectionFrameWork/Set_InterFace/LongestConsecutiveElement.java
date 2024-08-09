package CollectionFrameWork.Set_InterFace;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveElement {
    public static void main(String[]args){
        int []nums={100,4,200,3,1,2};
        Set<Integer>set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen=Integer.MIN_VALUE;
        for(int num:set){
             if(!set.contains(num-1)){//starting number
                 int currNum=num;
                 int currLen=1;
                 while(set.contains(currNum+1)){
                     currLen++;
                     currNum++;
                 }
                 maxLen=Math.max(currLen,maxLen);
            }
        }
        System.out.println(maxLen);
    }
}
