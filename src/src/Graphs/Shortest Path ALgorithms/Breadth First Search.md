# Use for Non-Weighted Edges 
```java
//Since there are no weighted Edges so we will use BFS for Shortest Path...
    public int BFS(Map<Integer, List<Integer>> adjList, int n) {

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        
        

        while (!que.isEmpty()) {
            int u = que.poll();
            if (adjList.get(u) != null) {
                for (int v : adjList.get(u)) {
                    if (!visited[v]) {
                        que.add(v);
                        visited[v] = true;
                        distance[v] = distance[u] + 1;//distance of the child is increased by 1 from its parent
                    }
                }
            }
        }
        return distance[n-1];//Return the n-1 th distance
    }
```
