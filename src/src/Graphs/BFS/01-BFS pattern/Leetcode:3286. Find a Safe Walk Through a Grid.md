# 01-BFS
##  Key idea
  - dist[i][j] = minimum health lost to reach cell (i, j).
  - If the next cell is 0, push it to the front of the deque.
  - If the next cell is 1, push it to the back.
  - At the end, if the minimum health lost is less than health, return true; otherwise false.

```java
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();

        int[][] directions={
                {-1,0},
                {0,1},
                {1,0},
                {0,-1}
        };

        int[][] distance=new int[m][n];
        for(int[] dist:distance){
            Arrays.fill(dist,Integer.MAX_VALUE);
        }
        distance[0][0]=grid.get(0).get(0);

        Deque<int[]>deque=new ArrayDeque<>();
        deque.offerFirst(new int[]{0,0});

        while(!deque.isEmpty()){
            int[] rem=deque.pollFirst();

            int row=rem[0];
            int col=rem[1];

            for(int[] dir:directions){
                int newRow=dir[0]+row;
                int newCol=dir[1]+col;

                if(newRow<0 || newRow>=m || newCol<0 || newCol>=n) continue;

                int wt=grid.get(newRow).get(newCol);

                if(distance[row][col]+wt<distance[newRow][newCol]){
                    distance[newRow][newCol]=distance[row][col]+wt;

                    if(wt==0){
                        deque.offerFirst(new int[]{newRow,newCol});
                    }else{
                        deque.offerLast(new int[]{newRow,newCol});
                    }
                }
            }
        }

        return distance[m-1][n-1]<health;
    }
}
```
