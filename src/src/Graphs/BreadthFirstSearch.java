package Graphs;

import java.util.*;

public class BreadthFirstSearch {
    public static List<Integer>BFS(Map<Integer,List<Integer>>adjList){
        Queue<Integer>queue=new LinkedList<>();
        Set<Integer>isVisited=new HashSet<>();
        List<Integer>list=new ArrayList<>();
        queue.add(1);
        isVisited.add(1);
        list.add(1);
        while(!queue.isEmpty()){
           int u=queue.poll();
           if(adjList.get(u)!=null){
               for(int v:adjList.get(u)){
                   if(!isVisited.contains(v)){
                       queue.add(v);
                       isVisited.add(v);
                       list.add(v);
                   }
               }
           }
        }
        return list;
    }
    public static void main(String[] args) {
        int[][] nums={
                {1,2,8},
                {2,4,5},
                {2,5,10},
                {5,7,99},
                {4,1,894},

        };
        for(int[] num:nums){
            for(int n:num){
                System.out.print(n+",");
            }
            System.out.println();
        }
        for (int[] edge : nums) {
            Arrays.sort(edge);
            for (int i = 0; i < edge.length / 2; i++) {
                int temp = edge[i];
                edge[i] = edge[edge.length - i - 1];
                edge[edge.length - i - 1] = temp;
            }
        }
        for(int[] num:nums){
            for(int n:num){
                System.out.print(n+",");
            }
            System.out.println();
        }
        Map<Integer, List<Integer>>map=new HashMap<>();
        for(int[] num:nums){
            int v=num[0];
            int e=num[1];

            if(!map.containsKey(v)){
                map.put(v,new ArrayList<>());
            }
            map.get(v).add(e);
        }
        System.out.println(BFS(map));
    }
}
