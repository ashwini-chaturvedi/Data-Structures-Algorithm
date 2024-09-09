class Solution {
    public int[][] generateMatrix(int n) {
        int [][]res=new int[n][n];
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        int ele=1;
        int total=0;
        while(total<n*n){
            for(int j=left;j<=right&&total<n*n;j++){
                res[top][j]=ele;
                ele++;
                total++;
            }
            top++;
            for(int i=top;i<=bottom&&total<n*n;i++){
                res[i][right]=ele;
                ele++;
                total++;
            }
            right--;
            for(int j=right;j>=left&&total<n*n;j--){
                res[bottom][j]=ele;
                ele++;
                total++;
            }
            bottom--;
            for(int i=bottom;i>=top&&total<n*n;i--){
                res[i][left]=ele;
                ele++;
                total++;
            }
            left++;
        }
        return res;
    }
}
