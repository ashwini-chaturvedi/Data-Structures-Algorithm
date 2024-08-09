package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class unDirectedAdjacencyList {
    public static void main(String[]args){
        int[][] nums={
                {1,2},
                {2,4},
                {2,5},
                {5,7},
                {4,1}
        };
        Map<Integer, List<Integer>>adjList=new HashMap<>();
        for(int[] num:nums){
            int u=num[0];
            int v=num[1];
            if(!adjList.containsKey(u)){
                adjList.put(u,new ArrayList<>());
            }
            adjList.get(u).add(v);
            if(!adjList.containsKey(v)){
                adjList.put(v,new ArrayList<>());
            }
            adjList.get(v).add(u);
        }
        for(Map.Entry<Integer,List<Integer>> e:adjList.entrySet()){
            System.out.print(e.getKey()+"->"+e.getValue());
            System.out.println();
        }
    }
}
