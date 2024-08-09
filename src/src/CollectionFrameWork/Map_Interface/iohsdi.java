package CollectionFrameWork.Map_Interface;

import java.util.HashMap;
import java.util.Map;

public class iohsdi {
    public static void main(String[] args) {
        int[][]edges={{1,2},{2,3},{4,2}};
        Map<Integer,Integer> map=new HashMap<>();
        for(int[]arr:edges){
            int u=arr[0];
            int v=arr[1];
            if(!map.containsKey(u)){
                map.put(u,1);
            }else{
                map.put(u,map.get(u)+1);
            }
            if(!map.containsKey(v)){
                map.put(v,1);
            }else{
                map.put(v,map.get(v)+1);
            }
        }
        int ans=0;
        for(Map.Entry<Integer,Integer>e: map.entrySet()){
            if(e.getValue()== edges.length){
                ans= e.getKey();
                break;
            }
        }
        System.out.println(ans);
    }
}
