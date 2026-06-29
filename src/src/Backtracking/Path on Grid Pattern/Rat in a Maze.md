Given a binary matrix maze[][] of size n × n containing values 0 and 1, find all possible paths for a rat to travel from the source cell (0, 0) to the destination cell (n - 1, n - 1). The rat can move in four directions: up(U), down(D), left(L), and right(R).

1 represents an open cell through which the rat can move.
0 represents a blocked cell that cannot be traversed.
The rat can move only through open cells and cannot visit the same cell more than once in a path. Return all valid paths as strings consisting of 'U', 'D', 'L', and 'R', representing the sequence of moves taken by the rat.

Note: Return the paths in lexicographically increasing order. If no valid path exists, return an empty list.

Examples:

Input: maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}

Output: ["DDRDRR", "DRDDRR"]

![img](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929574/Web/Other/blobid0_1781254127.png)

Explanation: There are two valid paths from the source cell (0, 0) to the destination cell (3, 3).

```java
class Solution {
    public void solve(int[][] maze,StringBuilder op,int row,int col,List<String>list,int[][] directions){
        if(row<0 || row>=maze.length|| col<0 || col>=maze[0].length || maze[row][col]==0){
            return;
        }

        if(row==maze.length-1 && col==maze[0].length-1){
            list.add(op.toString());
           
        }

        for(int i=0;i<directions.length;i++){
            int[] dir=directions[i];

            int newI=dir[0]+row;
            int newJ=dir[1]+col;

            if(i==0){
                op.append('U');
            }else if(i==1){
                op.append('D');
            }else if(i==2){
                op.append('L');
            }else{
                op.append('R');
            }
            
            maze[row][col]=0;

            solve(maze,op,newI,newJ,list,directions);

            op.deleteCharAt(op.length()-1);
            maze[row][col]=1;
        }
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String>list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int[][] directions={
                {-1,0},//U
                {1,0},//D
                {0,-1},//L
                {0,1}//R
        };
        solve(maze,sb,0,0,list,directions);
        
        Collections.sort(list);

        return list;
    }
}
```
