```java
class Solution {
    public boolean topoOrder(Map<Integer, List<Integer>> adjList,int u,Set<Integer>visited,Set<Integer>inRecursion,Stack<Integer>st){

        visited.add(u);
        inRecursion.add(u);

        if(adjList.get(u)!=null){
            for(int v:adjList.get(u)){
                if(!visited.contains(v)){
                    if(topoOrder(adjList,v,visited,inRecursion,st)) return true;
                }else if(inRecursion.contains(v)){
                    return true;
                }
            }
        }
        inRecursion.remove(u);
        st.push(u);
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            adjList.put(i, new ArrayList<>());
            for (int num : graph[i]) {
                adjList.get(i).add(num);
            }
        }

        Set<Integer> inRecursion = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited.contains(i)) {
                topoOrder(adjList, i, visited, inRecursion, st);
            }
        }
        List<Integer> list = new ArrayList<>();

        while (!st.isEmpty()) {
            System.out.println(st.peek());
            list.add(0, st.pop());
        }
         Collections.sort(list);
         return list;
    }
}
```
