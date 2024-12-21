```java
class Solution {

    public long DFS(int currNode, int parentNode, Map<Integer, List<Integer>> Tree, int[] components, int[] values, int k) {
        long sum = 0; //This will store the Sum of the Current Subtree
        if (Tree.get(currNode) != null) {
            for (int neighbor : Tree.get(currNode)) { //Traverse the neighbors
                if (neighbor != parentNode) { //if the Neighbor is not the Parent Node then Traverse it other wise it will form a Circle
                    sum += DFS(neighbor, currNode, Tree, components, values, k);
                }
            }
        }

        sum += values[currNode]; //Add the Values of the Current Node to the Sum...

        if (sum % k == 0)//check if the sum of the Current Subtree is divisible by k
         components[0]++;  //if yess then It can Form a Component so Increase Component Count

        return sum; //Pass the sum
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        //Make the Tree
        Map<Integer, List<Integer>> Tree = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            Tree.putIfAbsent(u, new ArrayList<>());
            Tree.get(u).add(v);

            Tree.putIfAbsent(v, new ArrayList<>());
            Tree.get(v).add(u);
        }

        int[] components = { 0 };
        DFS(0, -1, Tree, components, values, k); //0 is the Current Node,-1 is the ParentNode of the Current Node since 0 is the Root Node so No ParentNode and Hence -1...
        return components[0];
    }
}

```
