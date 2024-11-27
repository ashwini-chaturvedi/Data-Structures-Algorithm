# Intuition
  We have to Find the Shortest Path & the edges are not weighted

# Approach
  1.Map the i with i+1 as given in the Question.
  
  2.Add the new Path between the nodes that are in "queries" array.
  
  3.Do BFS to Find the Shortest Path between 0 to n-1.

# Complexity
- Time complexity:
  O(N)

- Space complexity:
  O(N)

```java []
class Solution {

    //Since there are no weighted Edges so we will use BFS for Shortest Path...
    public int BFS(Map<Integer, List<Integer>> adjList, int n) {
        boolean[] visited = new boolean[n];

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> que = new LinkedList<>();

        que.add(0);
        visited[0] = true;
        distance[0] = 0;

        while (!que.isEmpty()) {
            int u = que.poll();
            if (adjList.get(u) != null) {
                for (int v : adjList.get(u)) {
                    if (!visited[v]) {
                        que.add(v);
                        visited[v] = true;
                        distance[v] = distance[u] + 1;//distance of the child is increased by 1 from its parents
                    }
                }
            }
        }
        return distance[n-1];//Return the n-1 th distance
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        //Make a Graph of i->i+1
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            adjList.put(i, new ArrayList<>());
            adjList.get(i).add(i + 1);
        }

        int[] result = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];

            adjList.get(u).add(v);//Add new Path

            result[i++] = BFS(adjList, n);//Calculated the Shortest Path.
        }
        return result;
    }
}

```
