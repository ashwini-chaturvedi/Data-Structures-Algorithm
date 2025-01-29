In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

Example:

![image](https://assets.leetcode.com/uploads/2021/05/02/reduntant1-2-graph.jpg)



Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]

Output: [1,4]

# DFS
```java
class Solution {
    //if Number of Edges==Number of Nodes then there is a Cycle in the Graph

    public void DFS(Map<Integer, List<Integer>> adjList, int u, Set<Integer> visited) {
        if (visited.contains(u)) return;

        visited.add(u);

        if (adjList.get(u) != null) {
            for (int v : adjList.get(u)) {
                if (!visited.contains(v)) {
                    DFS(adjList, v, visited);
                }
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            //if Number of Edges==Number of Nodes then there is a Cycle in the Graph
            //Now we will Check if the Graph has both the Nodes then we will check if both the Nodes are Connected  or not if they are Connected which means this edges is Redundant Edge.
            if (adjList.containsKey(u) && adjList.containsKey(v)) {//Both Nodes are Connected
                Set<Integer> visited = new HashSet<>();
                DFS(adjList, u, visited);//If Both Nodes are Connected or not.
                if (visited.contains(v)) {//if Connected then this is Redundant Edge
                    res[0] = u;
                    res[1] = v;
                } else {//if Both are Not Connected then add a Bidirectional Edge Between them.
                    adjList.putIfAbsent(u, new ArrayList<>());
                    adjList.get(u).add(v);

                    adjList.putIfAbsent(v, new ArrayList<>());
                    adjList.get(v).add(u);
                }
            } else {
                //if Both are not Present then add them and make an Edge between them.
                adjList.putIfAbsent(u, new ArrayList<>());
                adjList.get(u).add(v);

                adjList.putIfAbsent(v, new ArrayList<>());
                adjList.get(v).add(u);
            }
        }

        return res;
    }
}
```
# DSU
```java
class DSU {
    int[] Parents;
    int[] Ranks;

    DSU(int m, int n) {
        Parents = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            Parents[i] = i;
        }
        Ranks = new int[n + 1];
    }

    public int Find(int node) {
        if (node == Parents[node]) return node;

        return Parents[node] = Find(Parents[node]);
    }

    public void Union(int x, int y) {
        int parentX = Find(x);
        int parentY = Find(y);

        if (parentX == parentY) return;

        if (Ranks[parentX] > Ranks[parentY]) {
            Parents[parentY] = parentX;
        } else if (Ranks[parentX] < Ranks[parentY]) {
            Parents[parentX] = parentY;
        } else {
            Parents[parentY] = parentX;
            Ranks[parentX]++;
        }
    }
}

class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu=new DSU(edges.length,edges.length);//Use Disjoin Set Union Because According to the Problem Description there should be only one Component.
        //Sirf Ek Component Hone chahiye aur saare nodes Connected Hone chahiye.
        int[] res=new int[2];

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            if(dsu.Find(u)==dsu.Find(v)){//If Parents of both the Nodes are same which means they are already Connected and if another Connection is to be made that is Redundant and Hence, This Connection is Redundant.
                res[0]=u;
                res[1]=v;
            }else{
                dsu.Union(u,v);//Make Union of two Unconnected Nodes.
            }
        }
        return res;
    }
}

```
