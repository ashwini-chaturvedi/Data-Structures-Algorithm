package CollectionFrameWork.Map_Interface;

import java.util.HashMap;
import java.util.Map;

public class example {
    public static void main(String[]args){
        int[]arr={1,3,2,2,4,2};
        Map<Integer,Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int num:arr){
            if(!map.containsKey(num)){
                map.put(num,1);//constant time complexity

            }else{
                map.put(num,map.get(num)+1);
            }

        }
        System.out.println(map);

        int res=0;
        for(Map.Entry<Integer,Integer>num:map.entrySet()){
            max=Math.max(num.getValue(),max);
            if(num.getValue()==max){
                res=num.getKey();
            }
        }
        System.out.println(max);
        System.out.println("Most Frequent Element:"+res);
    }
}
