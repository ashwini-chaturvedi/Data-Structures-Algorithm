package Graphs;

import java.util.*;

import static Trees.ec.DFS;

public class DepthFirstSearch {
    public static void DFSG(Map<Integer,List<Integer>>adjList,int u,Set<Integer>isVisited,List<Integer>list){
        if(isVisited.contains(u)){
            return;
        }
        isVisited.add(u);
        list.add(u);
        if(adjList.get(u)!=null){
            for(int v:adjList.get(u)){
                if(!isVisited.contains(v)){
                    DFSG(adjList,v,isVisited,list);
                }
            }
        }

    }
    public static void main(String[]args){
        int[][] nums={
                {1,2},
                {2,4},
                {2,5},
                {5,7},
                {4,1},
                {4,0}
        };
        Map<Integer, List<Integer>> adjList=new HashMap<>();
        for(int[] num:nums){
            int v=num[0];
            int e=num[1];
            if(!adjList.containsKey(v)){
                adjList.put(v,new ArrayList<>());
            }
            adjList.get(v).add(e);
        }
        List<Integer>list=new ArrayList<>();
        Set<Integer>isVisited=new HashSet<>();
        //we will Start from 1 th
        DFSG(adjList,1,isVisited,list);
        System.out.println(list);
    }
}
