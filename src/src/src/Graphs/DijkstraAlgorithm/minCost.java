package Graphs.DijkstraAlgorithm;

import java.util.*;

class u {
    char v;
    int wt;

    u(char node, int w) {
        v = node;
        wt = w;
    }
}

public class minCost {
    public static int dijkstra(Map<Character, List<u>> adjList, char source, char target, int V) {
        int[] result = new int[26];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[source - 'a'] = 0;

        PriorityQueue<u> minHeap = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        minHeap.add(new u(source, 0));
        while (!minHeap.isEmpty()) {
            u curr = minHeap.remove();
            char currChar = curr.v;
            int currCost = curr.wt;

            if (adjList.get(currChar) != null) {
                for (int i=0;i<adjList.get(currChar).size();i++) {
                    char node = adjList.get(currChar).get(i).v;
                    int costing = adjList.get(currChar).get(i).wt;

                    if (result[node-'a'] > currCost + costing) {
                        result[node-'a'] = currCost + costing;
                        minHeap.add(new u(node, currCost + costing));
                    }
                }
            }
        }
        return result[target - 'a'] == Integer.MAX_VALUE ? -1 : result[target - 'a'];
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        Map<Character, List<u>> adjList = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            char u = original[i];
            char v = changed[i];
            int wt = cost[i];

            if (!adjList.containsKey(u)) {
                adjList.put(u, new ArrayList<>());
            }
            adjList.get(u).add(new u(v, wt));
        }
        long minCost = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                minCost += dijkstra(adjList, source.charAt(i), target.charAt(i), source.length());
            }
        }
        return minCost <= 0 ?(long) -1 : minCost;
    }
    public static void main(String[]args){
        String source = "abcd";
        String target = "acbe";
        char[] original = {'a','b','c','c','e','d'};
        char[] changed = {'b','c','b','e','b','e'};
        int []cost = {2,5,5,1,2,20};
        System.out.println(minimumCost(source,target,original,changed,cost));
    }
}
