package Graphs.DijkstraAlgorithm;

import java.util.*;

class Pair{
    int dist;
    int desti;
    Pair(int nod,int d){
        this.dist=d;
        this.desti=nod;
    }
}
public class minHeapImplementation {
    public static int[] dijkstra(Map<Integer,List<int[]>>adjList,int source, int V){
        PriorityQueue<Pair>minHeap=new PriorityQueue<>((a,b)->a.dist-b.dist);//using a minHeap with priority at dist

        int[]result=new int[V];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[source]=0;

        minHeap.add(new Pair(source,0));//adding the current distance and the destination node to the minHeap

        while(!minHeap.isEmpty()){
            int d=minHeap.peek().dist;//distance of the node from the source
            int node=minHeap.peek().desti;//the node
            minHeap.remove();
            if(adjList.get(node)!=null){
                for(int []v:adjList.get(node)){
                    int adjNode=v[0];//the connecting or neighbour node
                    int weight=v[1];//the weight of the current vertices
                    if(d+weight<result[adjNode]){//if the weight of current vertices and the previous vertices is less then
                        //what we have stored in the result then put this in result
                        result[adjNode]=d+weight;
                        minHeap.add(new Pair(adjNode,d+weight));
                    }
                }
            }
        }
        return result;

    }
    public static void main(String[]args){
        int V = 3, E = 3;
      int[][][]arr = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};
      int source = 2;
        Map<Integer,List<int[]>>adjList=new HashMap<>();
        for(int i=0;i<V;i++){
            adjList.put(i,new ArrayList<int[]>());
            for(int[]v:arr[i]){
                adjList.get(i).add(new int[]{v[0],v[1]});
            }
        }
        int[]res=dijkstra(adjList,source,V);
        for(int num:res){
            System.out.print(num+",");
        }


    }
}
