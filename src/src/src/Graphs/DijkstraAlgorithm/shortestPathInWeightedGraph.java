package Graphs.DijkstraAlgorithm;

import java.util.*;

class pair {
    int dist;
    int node;

    pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}



public class shortestPathInWeightedGraph {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Create adjacency list
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(new int[]{v, w});

            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(new int[]{u, w});
        }

        // Distance array to store the shortest path distance to each node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        // Priority queue to get the node with the smallest distance
        PriorityQueue<pair> minHeap = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        minHeap.add(new pair(0, 1));

        // Parent array to reconstruct the path
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        while (!minHeap.isEmpty()) {
            pair current = minHeap.poll();
            int currDist = current.dist;
            int currNode = current.node;

            if (adjList.get(currNode) != null) {
                for (int[] neighbor : adjList.get(currNode)) {
                    int adjNode = neighbor[0];
                    int weight = neighbor[1];

                    if (dist[adjNode] > currDist + weight) {
                        dist[adjNode] = currDist + weight;
                        minHeap.add(new pair(dist[adjNode], adjNode));
                        parent[adjNode] = currNode;
                    }
                }
            }
        }

        // Reconstruct path from source (1) to destination (n)
        List<Integer> path = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        for (int at = n; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        List<Integer> result = new ArrayList<>();
        result.add(dist[n]);
        result.addAll(path);

        return result;
    }
    public static void main(String[]args){
        int n = 5, m= 6;
        int[][]edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(shortestPath(n,m,edges));

    }


}
