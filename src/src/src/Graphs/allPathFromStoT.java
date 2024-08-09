package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class allPathFromStoT {
    public void solve(Map<Integer, List<Integer>> adjList, int source, int target, List<Integer> ans, List<List<Integer>> list) {
        if (source == target) {
            list.add(new ArrayList<>(ans));
            return;
        }
        if (adjList.get(source) != null) {
            for (int v : adjList.get(source)) {
                ans.add(v);
                solve(adjList, v, target, ans, list);
                ans.remove(ans.size() - 1);//BackTracking
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            adjList.put(i, new ArrayList<>());

            for (int edge : graph[i]) {
                adjList.get(i).add(edge);
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        List<List<Integer>> list = new ArrayList<>();

        solve(adjList, 0, graph.length - 1, ans, list);

        return list;
    }
    public static void main(String[]args){

    }
}
