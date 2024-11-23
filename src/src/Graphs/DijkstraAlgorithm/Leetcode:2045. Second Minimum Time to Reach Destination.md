```java
  class pair {
    int v;
    int cost;

    pair(int node, int c) {
        v = node;
        cost = c;
    }
}
//Approach:
// 1. when we get a number in shortest path bigger will put it in shortestPath2nd because this element will now be out second minimum timed path...
// 2. 
class Solution {

    public int dijkstra(Map<Integer, List<Integer>> adjList, int source, int V, int change,int time) {
        int[] shortestPath = new int[V+1];
        int[] shortestPath2nd = new int[V+1];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        Arrays.fill(shortestPath2nd, Integer.MAX_VALUE);
        shortestPath[source]=0;

        PriorityQueue<pair> minHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        minHeap.add(new pair(source, 0));

        while (!minHeap.isEmpty()) {
            pair curr = minHeap.remove();
            int currNode = curr.v;
            int timePassed = curr.cost;
            
            if(shortestPath2nd[V]!=Integer.MAX_VALUE && currNode==V){//reached the target means V is targetor n'th node is target...
                return shortestPath2nd[V];
            }

            //Calculating the time taken 
            int multi=timePassed/change;
            if(multi%2==1){
                timePassed=change*(multi+1);
            }

            if (adjList.get(currNode) != null) {
                for (int nbr : adjList.get(currNode)) {
                    if(shortestPath[nbr]>timePassed+time){//got value smaller then element in array which means the element in array will now represent the time of second path 
                        shortestPath2nd[nbr]=shortestPath[nbr];//the element of the array will now be stored in the array storing the 2nd shortest path or minimum timed path..  
                        shortestPath[nbr]=timePassed+time;// putting the shortest path...

                        minHeap.add(new pair(nbr,timePassed+time));

                    }else if(shortestPath2nd[nbr]>timePassed+time && shortestPath[nbr]!=timePassed+time){
                        shortestPath2nd[nbr]=timePassed+time;//Update the 2nd Shortest Path.
                        minHeap.add(new pair(nbr,timePassed+time));
                    }
                }
            }
        }
        return -1;
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!adjList.containsKey(u)) {
                adjList.put(u, new ArrayList<>());
            }
            adjList.get(u).add(v);

            if (!adjList.containsKey(v)) {
                adjList.put(v, new ArrayList<>());
            }
            adjList.get(v).add(u);
        }       
        
        return dijkstra(adjList, 1, n, change,time);
    }
}
  ```
