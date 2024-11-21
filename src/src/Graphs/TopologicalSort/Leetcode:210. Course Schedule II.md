# Without Cycle Detection 
```java
class Solution {
    public void topoOrder(Map<Integer,List<Integer>>adjList,int u,Set<Integer>visited,Stack<Integer>st){
        if(visited.contains(u)) return;

        visited.add(u);

        if(adjList.get(u)!=null){
            for(int v:adjList.get(u)){
                if(!visited.contains(v)){
                    topoOrder(adjList,v,visited,st);
                }
            }
        }
        st.push(u);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        

        Map<Integer,List<Integer>>adjList=new HashMap<>();
        for(int[] pre:prerequisites){
            adjList.putIfAbsent(pre[0],new ArrayList<>());
            adjList.get(pre[0]).add(pre[1]);
        }

        Stack<Integer>st=new Stack<>();
        Set<Integer>visited=new HashSet<>();

        for(int i=0;i<numCourses;i++){

            if(!visited.contains(i)){
                topoOrder(adjList,i,visited,st);
            }
        }
        int[] topologicalSort=new int[numCourses];
        int i=st.size()-1;
        while(!st.isEmpty()){
            topologicalSort[i--]=st.pop();
        }
        return topologicalSort;
    }
}

//When:
      numCourses =2
      prerequisites =[[0,1],[1,0]]
//Here Graph is Forming a Cycle...
```
# With Graph Detection
```java
class Solution {
    public boolean topoOrder(Map<Integer,List<Integer>>adjList,int u,Set<Integer>visited,Set<Integer>inRecursion,Stack<Integer>st){
        
        visited.add(u);
        inRecursion.add(u);

        if(adjList.get(u)!=null){
            for(int v:adjList.get(u)){
                if(!visited.contains(v)){
                    if(topoOrder(adjList,v,visited,inRecursion,st)) return true ;
                }else if(inRecursion.contains(v)) return true;
            }
        }
        st.push(u);
        inRecursion.remove(u);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {       
        //As we go from any course to another course so it is a directed graph and we can find topological sort in directed graph only
        Map<Integer,List<Integer>>adjList=new HashMap<>();
        for(int[] pre:prerequisites){
            adjList.putIfAbsent(pre[0],new ArrayList<>());
            adjList.get(pre[0]).add(pre[1]);
        }

        Stack<Integer>st=new Stack<>();//for storing the elements in topological way

        Set<Integer>visited=new HashSet<>();
        Set<Integer>inRecursion=new HashSet<>();//For Cycle Detection in Graph as it is a Directed Graph

        for(int i=0;i<numCourses;i++){

            if(!visited.contains(i)){
                if(topoOrder(adjList,i,visited,inRecursion,st)) return new int[0];
            }
        }
        int[] topologicalSort=new int[numCourses];
        int i=st.size()-1;
        while(!st.isEmpty()){
            topologicalSort[i--]=st.pop();
        }
        return topologicalSort;
    }
}
```
