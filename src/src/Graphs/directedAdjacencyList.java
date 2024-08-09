package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class directedAdjacencyList {
    public static void main(String[]args){
        int[][] nums={
                {1,2},
                {2,4},
                {2,5},
                {5,7},
                {4,1}
        };
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] num:nums){
            int v=num[0];
            int e=num[1];
            if(!map.containsKey(v)){
                map.put(v,new ArrayList<>());
            }
            map.get(v).add(e);
        }
        for(Map.Entry<Integer,List<Integer>>e:map.entrySet()){
            System.out.println(e.getKey()+"-"+e.getValue());
            System.out.println(e.getValue());
        }
    }
}
