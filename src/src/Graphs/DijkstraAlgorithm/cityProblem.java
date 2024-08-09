package Graphs.DijkstraAlgorithm;

import java.util.*;

class couple{
    int v;
    int wt;

    couple(int n,int w){
        v=n;
        wt=w;
    }
}



public class cityProblem {
    public static int[] dijkstra(Map<Integer, List<int[]>> adjList, int n){
        int[] result=new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[0]=0;

        PriorityQueue<couple> minHeap=new PriorityQueue<>((a, b)->a.wt-b.wt);
        minHeap.add(new couple(0,0));

        while(!minHeap.isEmpty()){
            couple current=minHeap.poll();
            int currNode=current.v;
            int currWt=current.wt;
            if(adjList.get(currNode)!=null){
                for(int[] neighbor:adjList.get(currNode)){
                    int node=neighbor[0];
                    int weight=neighbor[1];
                    if(result[node]>currWt+weight){
                        result[node]=currWt+weight;
                        minHeap.add(new couple(node,currWt+weight));
                    }
                }
            }
        }

        return result;
    }
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer,List<int[]>>adjList=new HashMap<>();
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];

            if(!adjList.containsKey(u)){
                adjList.put(u,new ArrayList<>());
            }
            adjList.get(u).add(new int[]{v,wt} );

            if(!adjList.containsKey(v)){
                adjList.put(v,new ArrayList<>());
            }
            adjList.get(v).add(new int[]{u,wt} );
        }
        int[] res=dijkstra(adjList,n);
        int dist=Integer.MIN_VALUE;
        for(int i=0;i<res.length;i++){
            if(res[i]==distanceThreshold){
                dist=i;
            }
        }
        for(int num:res){
            System.out.print(num+",");
        }
        System.out.println();
        return dist+1;
    }
    public static void main(String[]args){
        int n = 4;
        int[][]edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;

        System.out.println(findTheCity(n,edges,distanceThreshold));
    }
}
