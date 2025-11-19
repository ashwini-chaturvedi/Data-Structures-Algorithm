package Graphs.TopologicalSort;

import java.util.*;

public class topologicalSortDFS {
    //MOST IMPORTANT
    public static void Tsort(Map<Integer, List<Integer>> adjList,int u,Set<Integer>visited,Stack<Integer>st){
        if(visited.contains(u)) return ;
        visited.add(u);
        if(adjList.get(u)!=null){
            for(int v:adjList.get(u)){
                if(!visited.contains(v)){
                    Tsort(adjList,v,visited,st);
                }
            }
        }
        st.push(u);
    }
    public static void main(String[]args){
        int[][] num={
                {0,2},
                {0,3},
                {1,4},
                {2,1},
                {2,3},
                {3,1},

                {5,1},
                {5,4}
        };
        Map<Integer, List<Integer>> adjList=new HashMap<>();
        for(int[] n:num){
            int v=n[0];
            int e=n[1];
            if(!adjList.containsKey(v)){
                adjList.put(v,new ArrayList<>());
            }
            adjList.get(v).add(e);
        }

        Set<Integer> visited=new HashSet<>();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<6;i++){
            if(!visited.contains(i)){
                Tsort(adjList,i,visited,st);
            } 
        }
        List<Integer>res=new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        System.out.println(res);
    }
}
