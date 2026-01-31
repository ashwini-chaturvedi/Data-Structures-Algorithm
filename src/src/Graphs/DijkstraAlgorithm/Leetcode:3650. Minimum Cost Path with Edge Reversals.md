```java
class Solution {
    public int dijkstra(Map<Integer,List<int[]>>adjList,int src,int dest,int n){
        int[] result=new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[src]=0;
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        minHeap.add(new int[]{src,0});

        while(!minHeap.isEmpty()){
            int[] node=minHeap.poll();
            int u=node[0];
            int wt=node[1];

            if(adjList.get(u)!=null){
                for(int[]adjNode:adjList.get(u)){
                    int v=adjNode[0];
                    int adjWt=adjNode[1];

                    if(adjWt+wt<result[v]){
                        result[v]=adjWt+wt;
                        minHeap.add(new int[]{v,adjWt+wt});
                    }
                }
            }

        }

        return result[dest]==Integer.MAX_VALUE?-1:result[dest];
    }
    public int minCost(int n, int[][] edges) {
        Map<Integer,List<int[]>>adjList=new HashMap<>();

        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];

            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.get(u).add(new int[]{v,wt});

            //IMPORTANT:Precalculating the revese weight and connecting the nodes in reverse.
            adjList.putIfAbsent(v,new ArrayList<>());
            adjList.get(v).add(new int[]{u,(2*wt)});
        }

        return dijkstra(adjList,0,n-1,n);
    }
}
```
