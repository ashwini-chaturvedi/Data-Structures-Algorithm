package Queue.CircularQueue;
class Solution {

    public void dfs(int[][]grid,int i,int j,int perimeter,int row,int col){
        if(i<0||i>=row||j<0||j>=col||grid[i][j]==0){
            //means that there should be a wall which ends the Island boundary
            perimeter+=1;
            return;
        }
        if(grid[i][j]==-1){
            //this grid is visited previously...
            return;
        }
        grid[i][j]=-1;//marking the grid as visited...

        dfs(grid,i+1,j,perimeter,row,col);
        dfs(grid,i-1,j,perimeter,row,col);
        dfs(grid,i,j+1,perimeter,row,col);
        dfs(grid,i,j-1,perimeter,row,col);
    }
    public int islandPerimeter(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
          final int perimeter=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    //we found the Island now we step onto it and perform dfs to all the connected grids of Island...
                    dfs(grid,i,j,perimeter,row,col);
                    return perimeter;
                }
            }
        }
        return -1;
    }
}
public class jnlk {
    public static void main(String[] args) {
        int [][]grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        Solution s=new Solution();

        System.out.println(  s.islandPerimeter(grid));
    }
}
