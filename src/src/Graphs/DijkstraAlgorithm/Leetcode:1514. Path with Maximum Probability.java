class pair {
    double node;
    double wt;

    pair(double n, double w) {
        node = n;
        wt = w;
    }
}

class Solution {

    public double dijkstra(Map<Integer, List<double[]>> adjList, int s, int d, int V) {
        double[] res = new double[V];
        Arrays.fill(res, Double.MIN_VALUE);
        res[s] = 1;

        PriorityQueue<pair> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.wt, a.wt));
        maxHeap.add(new pair(s, 1));

        while (!maxHeap.isEmpty()) {
            pair curr = maxHeap.poll();
            int u = (int) curr.node;
            double wt = curr.wt;

            if (adjList.get(u) != null) {
                for (double[] v : adjList.get(u)) {
                    int node = (int) v[0];
                    double currWt = v[1];
                    if (res[node] < currWt * wt) {//here we have to do multiplication to find Maximum Probability
                        res[node] = currWt * wt;
                        maxHeap.add(new pair(node, currWt * wt));
                    }
                }
            }
        }
        return res[d] == Double.MAX_VALUE ? (double) 0 : res[d];
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        int i = 0;
        Map<Integer, List<double[]>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            double wt = succProb[i];
            i++;
            if (!adjList.containsKey(u)) {
                adjList.put(u, new ArrayList<>());
            }
            adjList.get(u).add(new double[] { v, wt });
              if (!adjList.containsKey(v)) {
                adjList.put(v, new ArrayList<>());
            }
            adjList.get(v).add(new double[] { u, wt });
           
           
        }

        double res = dijkstra(adjList, start_node, end_node, n);
        return res;
    }
}
