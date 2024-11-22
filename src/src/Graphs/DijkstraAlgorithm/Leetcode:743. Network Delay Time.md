```java
class Pair{
    int u;
    int wt;

    Pair(int v,int w){
        u=v;
        wt=w;
    }
}
class Solution {
    public int Dijkstra(Map<Integer,List<Pair>>adjList,int s,int n){
        //Result Array this will Store all the Shortest distance between source(s) to all the nodes 1 to n
        int[] result=new int[n+1];//1 based Indexing
        Arrays.fill(result,Integer.MAX_VALUE);
        result[s]=0;

        PriorityQueue<Pair>minHeap=new PriorityQueue<>((a,b)->a.wt-b.wt);
        minHeap.add(new Pair(s,0));

        while(!minHeap.isEmpty()){
            Pair curr=minHeap.poll();
            int u=curr.u;
            int wt=curr.wt;

            if(adjList.get(u)!=null){
                for(Pair v:adjList.get(u)){
                    int adjNode=v.u;
                    int adjWt=v.wt;

                    if(result[adjNode]>wt+adjWt){
                        result[adjNode]=wt+adjWt;
                        minHeap.add(new Pair(adjNode,wt+adjWt));
                    }
                }
            }
        }
// Why calculate the maximum time?
// The problem asks:

// "What is the minimum time it takes for all n nodes to receive the signal?"

// This means that for all nodes to receive the signal, the signal must reach the farthest node (i.e., the node that takes the longest time to receive the signal). Hence, the maximum value in the result array represents the minimum time needed to ensure that all nodes have received the signal.

        int max=-1;
        for(int i=1;i<=n;i++){
            max=Math.max(result[i],max);
        }
        return max==Integer.MAX_VALUE?-1:max;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer,List<Pair>>adjList=new HashMap<>();
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int wt=time[2];

            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.get(u).add(new Pair(v,wt));
        }
        
        return Dijkstra(adjList,k,n);
    }
}
```
