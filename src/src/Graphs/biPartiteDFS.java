package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class biPartiteDFS {
    public static boolean DFS(Map<Integer, List<Integer>> adjList, int currNode, int[] colors, int currColor) {
        colors[currNode] = currColor;
        if (adjList.get(currNode) != null) {
            for (int v : adjList.get(currNode)) {
                if (colors[currNode] == colors[v]) return false;


                if (colors[v]==0 && !DFS(adjList, v, colors, -currColor)) return false;
            }
        }
        return true;
    }

    public static boolean isBipartite( Map<Integer, List<Integer>> adjList,int n) {

        int[] colors = new int[n];
        //Red: 1;
        //Green= -1;
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                if (!DFS(adjList, i, colors, 1)) return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
        int[][] graph={
                {1,3},{0,2},{1,3},{0,2}

        };
        int n = graph.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
            for (int j : graph[i]) {
                adjList.get(i).add(j);
            }
        }

        System.out.println(isBipartite(adjList, graph.length));
        for(var e:adjList.entrySet()){

        }

    }
}
