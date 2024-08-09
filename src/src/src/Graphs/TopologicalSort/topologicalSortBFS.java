package Graphs.TopologicalSort;

import java.util.*;

public class topologicalSortBFS {
    public static void main(String[]args){
        //KAHN's Algo
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
        int[] inDegree=new int[6];
        for(int i=0;i<6;i++){
            if(adjList.get(i)!=null){
                for(int v:adjList.get(i)){
                    inDegree[v]++;
                }
            }
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<6;i++){
            if(inDegree[i]==0) queue.add(i);
        }
        int[] ans=new int[6];
        int i=0;
        while(!queue.isEmpty()){
            int u=queue.poll();
            ans[i++]=u;
            if(adjList.get(u)!=null){
                for(int v:adjList.get(u)){
                    inDegree[v]--;
                    if(inDegree[v]==0) queue.add(v);
                }
            }

        }
        for(int j=0;j<ans.length;j++){
            System.out.print(ans[j]+",");
        }
    }
}
