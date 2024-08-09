package Graphs.DijkstraAlgorithm;

import java.util.*;

 class tuple{
     int distt;
     int node;
     tuple(int n,int d){
         node=n;
         distt=d;
     }
}

public class setImplementation {
    public static int[] dijkstra( Map<Integer,List<int[]>> adjList,int source,int V){
        int[] res=new int[V];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[source]=0;

        TreeSet<tuple> set = new TreeSet<>((a, b) -> {
            if (a.distt != b.distt) {//if both are not equal equate on that else equate on node...
                return Integer.compare(a.distt, b.distt);
            } else {
                return Integer.compare(a.node, b.node);
            }
        });
        set.add(new tuple(source,0));
        while(!set.isEmpty()){
            tuple tup=set.pollFirst();
            int currNode=tup.node;
            int prevDist=tup.distt;
            if(adjList.get(currNode)!=null){
                for(int []v:adjList.get(currNode)){
                    int node=v[0];
                    int weight=v[1];
                    if(prevDist+weight<res[node]){
                        set.remove(new tuple(node,res[node]));
                        res[node]=prevDist+weight;
                        set.add(new tuple(node,prevDist+weight));
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[]args){
        int V = 3, E = 3;
        int[][][]arr = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};
        int source = 2;
        Map<Integer,List<int[]>> adjList=new HashMap<>();
        for(int i=0;i<V;i++){
            adjList.put(i,new ArrayList<>());
            for(int[]v:arr[i]){
                adjList.get(i).add(new int[]{v[0],v[1]});
            }
        }
        int [] res=dijkstra(adjList,source,V);
        for(int num:res){
            System.out.print(num+",");
        }
    }
}
