The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:
![img](https://assets.leetcode.com/uploads/2020/11/13/queens.jpg)

Input: n = 4

Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

```java
class Solution {
    public boolean isNotUnderAttack(List<String>ans,int n,int row,int col){
        //for Row
        for(int currRow=0;currRow<n;currRow++){
            if(currRow==row) break;
            if(ans.get(currRow).charAt(col)=='Q') return false;
        }

        for(int currRow=row,currCol=col;currRow>=0 && currCol>=0;currRow--,currCol--){
            if(ans.get(currRow).charAt(currCol)=='Q') return false;
        }
        for(int currRow=row,currCol=col;currRow>=0 && currCol<n;currRow--,currCol++){
            if(ans.get(currRow).charAt(currCol)=='Q') return false;
        }

        return true;
    }
    public void solve(List<List<String>>list,List<String>ans,int n,int row){
        if(row==ans.size()){
            list.add(new ArrayList<>(ans));
            return;
        }

        for(int col=0;col<n;col++){
            if(isNotUnderAttack(ans,n,row,col)){
                StringBuilder sb=new StringBuilder(ans.get(row));
                sb.setCharAt(col,'Q');
                ans.set(row,sb.toString());

                solve(list,ans,n,row+1);

                sb.setCharAt(col,'.');
                ans.set(row,sb.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>list=new ArrayList<>();
        List<String>ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            sb.repeat('.',n);

            ans.add(sb.toString());
        }

        solve(list,ans,n,0);

        return list;
    }
}
```
