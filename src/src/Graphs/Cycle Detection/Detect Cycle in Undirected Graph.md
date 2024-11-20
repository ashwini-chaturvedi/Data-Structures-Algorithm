```java
    public boolean solve(Map<Integer,List<Integer>>adjList,int u,Set<Integer>visited,int parent){
        
        visited.add(u);
        if(adjList.get(u)!=null){
            for(int v:adjList.get(u)){
                if(v==parent) continue;
                if(visited.contains(v)) return true;
                if(solve(adjList,v,visited,u)) return true;
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Map<Integer,List<Integer>>adjList=new HashMap<>();
        
        for(int i=0;i<adj.size();i++){
            adjList.put(i,adj.get(i));
           
        }
        
        Set<Integer>visited=new HashSet<>();
        
        for(int i=0;i<adj.size();i++){
            if(!visited.contains(i) && solve(adjList,i,visited,-1)){
                return true;
            }
        }
        return false;
    }
}
```
