```java
class Solution {
    //we will use a boolean array to store that this node is visited or not if any of the node is not visited after DFS that means we cant reach to that room and hence false...
    public void DFS(Map<Integer,List<Integer>>adjList,int source,boolean[] isVisited){
        
        if(isVisited[source]) return;
        isVisited[source]=true;

        if(adjList.get(source)!=null){
            for(int curr:adjList.get(source)){
                if(!isVisited[curr]){
                    DFS(adjList,curr,isVisited);
                }
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //Make a Graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < rooms.size(); i++) {
            List<Integer> keys = rooms.get(i);
            adjList.put(i, keys);
        }

        boolean[] isVisited = new boolean[rooms.size()];//To track the visited mode 
        

        DFS(adjList, 0, isVisited);//Traversal

        for (boolean flag : isVisited) {
            if (flag == false)//if any of the room is false means it is not visited and hence false...
                return false;
        }
        return true;
    }
}
```
