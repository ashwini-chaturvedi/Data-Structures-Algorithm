# DFS
```java
class Solution {
    public boolean DFS( Map<Integer,List<Integer>>adjList,int u,  Set<Integer>visited,Set<Integer>inRecursion,Stack<Integer>st){
        visited.add(u);
        inRecursion.add(u);

        if(adjList.get(u)!=null){
            for(int v:adjList.get(u)){
                if(!visited.contains(v)){
                    if(DFS(adjList,v,visited,inRecursion,st)) return true;
                }else if(inRecursion.contains(v)) return true;
            }
        }
        st.push(u);
        inRecursion.remove(u);
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>>adjList=new HashMap<>();
        for(int[]num:prerequisites){
            int u=num[0];
            int v=num[1];
            if(!adjList.containsKey(u)){
                adjList.put(u,new ArrayList<>());
            }
            adjList.get(u).add(v);
        }
        Set<Integer>visited=new HashSet<>();
        Set<Integer>inRecursion=new HashSet<>();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!visited.contains(i)){
                if(DFS(adjList,i,visited,inRecursion,st)) return false;
            }
        }
        return st.size()==numCourses?true:false;
    }
}
```
# BFS
```java
class Solution {

    public boolean topoSortBFS(Map<Integer, List<Integer>> adjList,int n) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (adjList.get(i) != null) {
                for (int v : adjList.get(i)) {
                    inDegree[v]++;
                }
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }
        int count = 0;
        while (!que.isEmpty()) {
            int V = que.poll();
            count++;
            if (adjList.get(V) != null) {
                for (int v : adjList.get(V)) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) {
                        que.add(v);
                    }
                }
            }
        }
        return count == n;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] num : prerequisites) {
            int u = num[0];
            int v = num[1];
            if (!adjList.containsKey(u)) {
                adjList.put(u, new ArrayList<>());
            }
            adjList.get(u).add(v);
        }
        
        int n = numCourses;
       
        return topoSortBFS(adjList, n);
    }
}
```
