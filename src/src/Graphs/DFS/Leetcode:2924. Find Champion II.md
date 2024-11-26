# Clever Approach
```java
class Solution {
    //Intuition:Any node(team) which has to be the winner should have its inDegree zero which means from any other node we can't reach the current node because if we can then this node is weaker than the source node so this can't be champion.
    //so find the node which has indegree==0
    public int findChampion(int n, int[][] edges) {
    
        int[] inDegree=new int[n];
        for(int[]edge:edges){
            int u=edge[0];
            int v=edge[1];

            inDegree[v]++;//reaching to v from u so increasing the inDegree count of v
        }

        int countOfChampions=0;
        int champion=-1;

        for(int i=0;i<n;i++){
            if(inDegree[i]==0){//if inDegree is zero then it can be our champion
                countOfChampions++;
                champion=i;
            }
            if(countOfChampions>1) return -1;//there can only be one champion 
        }
        return champion;
    }
}
```

# DFS Approach
```java
class Solution {

    public boolean allTrue(boolean[] visited) {
        for (boolean flag : visited) {
            if (!flag) return false;
        }
        return true;
    }

    public void DFS(Map<Integer, List<Integer>> adjList, int u, boolean[] visited) {
        visited[u] = true;

        if (adjList.get(u) != null) {
            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    DFS(adjList, v, visited);
                }
            }
        }
    }

    public int findChampion(int n, int[][] edges) {
        //Make a Graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
        }

        //Since Graph is DAG
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n]; //checking if the node is visited or not
            DFS(adjList, i, visited);
            if (allTrue(visited)) { //if we can visit all the nodes from this current node then this node is the champion because all other team is weaker then this team...
                return i; //return the team
            }
        }
        return -1;
    }
}

```
