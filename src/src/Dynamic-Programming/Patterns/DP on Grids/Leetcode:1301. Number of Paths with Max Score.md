You are given a square board of characters. You can move on the board starting at the bottom right square marked with the character 'S'.

You need to reach the top left square marked with the character 'E'. The rest of the squares are labeled either with a numeric character 1, 2, ..., 9 or with an obstacle 'X'. In one move you can go up, left or up-left (diagonally) only if there is no obstacle there.

Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect, and the second is the number of such paths that you can take to get that maximum sum, taken modulo 10^9 + 7.

In case there is no path, return [0, 0].

 

Example 1:

Input: board = ["E23","2X2","12S"]

Output: [7,1]

Example 2:

Input: board = ["E12","1X1","21S"]

Output: [4,2]

Example 3:

Input: board = ["E11","XXX","11S"]

Output: [0,0]

# Top-Down/Recursion+Memoization
```java
class Solution {
    static int MOD = 1000000007;

    //In Recursion+ memoization Approach we first go to the top cell and then why coming back we calculate the best possible {score,noOfPath} from that cell.
    public int[] maxPathSum(List<String> board, int row, int col, int[][] scores, int[][] paths, boolean[][] visited) {
        if (row < 0 || col < 0 || board.get(row).charAt(col) == 'X') {
           
            return new int[] { 0, 0 };
        }

        if (row == 0 && col == 0) {
            scores[0][0] = 0;
            paths[0][0] = 1;
            visited[row][col] = true;
            return new int[] { 0, 1 };
        }

        if (visited[row][col]) return new int[] { scores[row][col], paths[row][col] };

        int[] up = maxPathSum(board, row - 1, col,scores,paths,visited);
        int[] left = maxPathSum(board, row, col - 1,scores,paths,visited);
        int[] diag = maxPathSum(board, row - 1, col - 1,scores,paths,visited);

        int leftScore = left[0];
        int leftPath = left[1];

        int upScore = up[0];
        int upPath = up[1];

        int diagScore = diag[0];
        int diagPath = diag[1];

        int val = Character.isDigit(board.get(row).charAt(col)) ? board.get(row).charAt(col) - '0' : 0;

        if (leftPath > 0) {
            leftScore += val;
        }

        if (upPath > 0) {
            upScore += val;
        }

        if (diagPath > 0) {
            diagScore += val;
        }

        int bestScore = 0;
        int noOfPaths = 0;

        bestScore = Math.max(leftScore, Math.max(upScore, diagScore));

        if (bestScore == leftScore) {
            noOfPaths += leftPath;
        }
        if (bestScore == upScore) {
            noOfPaths += upPath;
        }
        if (bestScore == diagScore) {
            noOfPaths += diagPath;
        }

        scores[row][col] = bestScore;
        paths[row][col] = noOfPaths % MOD;
        visited[row][col] = true;

        return new int[] { bestScore, noOfPaths % MOD };
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size();
        int n = board.get(0).length();

        int[][] scores = new int[m][n];
        int[][] paths = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        return maxPathSum(board, m - 1, n - 1, scores, paths, visited);
    }
}
```
---
# Bottom-up Approach:This is Bottom-Up approach means going from bottom most point to top 0,0 
```java
class Pair{
    int score;
    int path;

    Pair(int score,int path){
        this.score=score;
        this.path=path;
    }
}
class Solution {
    static int MOD=1000000007;
    public Pair maxPathScoreWithCount(List<String>board,int n){
        Pair[][] dp=new Pair[n+1][n+1];

        for(Pair[] num:dp){
            Arrays.fill(num,new Pair(-1,0));
        }

        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=new Pair(0,0);
                
                if(board.get(i).charAt(j)=='X'){
                    dp[i][j]=new Pair(-1,0);
                    
                }
                if(board.get(i).charAt(j)=='S'){
                    dp[i][j]=new Pair(0,1);
                    
                }
            }
        }

        for(int i=n-1;i>=0 ;i--){
            for(int j=n-1;j>=0; j--){

                if(i == n-1 && j == n-1 )
                    continue;
                if(board.get(i).charAt(j)=='X'){
                    continue;
                }

                //Computing the values
                Pair right=dp[i][j+1];
                Pair down=dp[i+1][j];
                Pair diag=dp[i+1][j+1];


                // Now Determining the best score and best path
                int rightScore=right.score; 
                int rightPath=right.path;

                int downScore=down.score; 
                int downPath=down.path; 

                int diagScore=diag.score; 
                int diagPath=diag.path; 

                int val=Character.isDigit(board.get(i).charAt(j))?board.get(i).charAt(j)-'0':0;

                if(rightPath>0){
                    rightScore+=val;
                }
                if(downPath>0){
                    downScore+=val;
                }
                if(diagPath>0){
                    diagScore+=val;
                }

                int best=Math.max(rightScore,Math.max(diagScore,downScore));
                 if(best == -1){
                   
                    continue;
                }
                int noOfPaths=0;

                if(best==rightScore){
                    noOfPaths+=rightPath;
                }
                if(best==downScore){
                    noOfPaths+=downPath;
                }
                if(best==diagScore){
                    noOfPaths+=diagPath;
                }

                dp[i][j]=new Pair(best,noOfPaths%MOD);
            }
        }

        return dp[0][0];
    }
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();

        Pair ans=maxPathScoreWithCount(board,n);

        return new int[]{ans.score,ans.path};
    }
}
```
