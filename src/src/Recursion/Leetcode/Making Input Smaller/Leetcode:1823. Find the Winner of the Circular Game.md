## Identification:"After Removing one player ,the remaining problem looks exactly the same,just with n-1 players.THIS SHOWS THAT INPUT IS GETTING SMALLER"
```java

class Solution {
    public int solve(int n, int k) {
    if (n == 1) return 0;//if one person exist at a time so 

    int winnerInSmallerCircle = solve(n - 1, k);

    int winnerInCurrentCircle =(winnerInSmallerCircle + k) % n;

    return winnerInCurrentCircle;
}
    public int findTheWinner(int n, int k) {       

        return solve(n,k)+1;//making it compatible for index based 1
       
    }
}
```
