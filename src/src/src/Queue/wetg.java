package Queue;
class Solutio{
    public int dfs(char[][]grid,int i,int j,int row,int col){
        if(i<0||i>=row||j<0||j>=col||grid[i][j]=='0'){
            return 1;
        }
        if(grid[i][j]=='2'){
            return 0;
        }
        grid[i][j]='2';

        int count=0;
        count=dfs(grid,i+1,j,row,col);
        count=dfs(grid,i-1,j,row,col);
        count=dfs(grid,i,j+1,row,col);
        count=dfs(grid,i,j-1,row,col);
        return count;

    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count = dfs(grid, i, j, row, col);
                    return count;
                }
            }
        }
        return count;
    }
}

public class wetg {
    public static void main(String[] args) {
        char[][]grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Solutio s=new Solutio();
       System.out.println( s.numIslands(grid));
    }
}
