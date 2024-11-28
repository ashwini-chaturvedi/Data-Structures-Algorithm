We will use Dijsktra + Move in all Directions because in a way this question is asking the shortest path to reach destination in a Grid 

  1.It wants MINIMUM Obstacles to be Removed.
    
  2.It wants to reach a destination from a source
    
  3.we only have to remove the obstacles when we have no other direction to go so "Move in all Directions Pattern".

```java
//  Dijkstra+Move in All directions

class Trio{
    int u;
    int v;
    int wt;

    Trio(int a,int b,int c){
        u=a;
        v=b;
        wt=c;
    }
}
class Solution {

    public int Dijkstra(int[][] grid,int m,int n,int[][] directions){

        int[][] result=new int[m][n];//2-D Array to Store the minimum number of obstacles removed to reach the current cell
        for(int[] res:result){
            Arrays.fill(res,Integer.MAX_VALUE);
        }        
        result[0][0]=0;

        PriorityQueue<Trio>minHeap=new PriorityQueue<>((a,b)->a.wt-b.wt);
        minHeap.add(new Trio(0,0,0));

        while(!minHeap.isEmpty()){
            Trio curr=minHeap.poll();
            int u=curr.u;
            int v=curr.v;
            int currObstaclesRemoved=curr.wt;

            //Now Move in all directions and count the obstacles to be removed and store them as a edge weight to the node.
            for(int[] dir:directions){
                int newU=u+dir[0];
                int newV=v+dir[1];
                if(newU>=0 && newU<m && newV>=0 && newV<n){

    
                    int obstacleToBeRemoved=(grid[newU][newV]==1?1:0);//Edges to cells with obstacles have a cost of 1 and all other edges have a cost of 0.

                    if(result[newU][newV]>obstacleToBeRemoved+currObstaclesRemoved){
                        result[newU][newV]=obstacleToBeRemoved+currObstaclesRemoved;
                        minHeap.add(new Trio(newU,newV,(obstacleToBeRemoved+currObstaclesRemoved)));
                    }
                }
            }
        }
        return result[m-1][n-1];
    }
    public int minimumObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] directions={
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };  

        return Dijkstra(grid,m,n,directions);
    }
}
```
