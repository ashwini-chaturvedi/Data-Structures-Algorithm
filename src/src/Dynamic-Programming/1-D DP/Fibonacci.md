# Top-Down(Recursion+Memoization)
```java
import java.util.*;

public class DP {
    public static int fibonacci(int num, int[] dp) {
        // Base cases
        if (num == 0) {

            return dp[num] = 0;
        }
        if (num == 1) {

            return dp[num] =1;
        }

        // Return memoized result if already computed
        if (dp[num] != -1) {
            return dp[num];
        }

        // Compute and memoize the result
        return dp[num]=fibonacci(num - 1, dp) + fibonacci(num - 2, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Handle negative input
        if (n < 0) {
            System.out.println("Fibonacci sequence is not defined for negative numbers.");
            return;
        }

        // Initialize DP array
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // Print Fibonacci numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i, dp) + (i < n ? ", " : "\n"));
        }
    }
}

```
# Bottom Up
```java
class Solution {

    public int fib(int n) {
        if (n == 0) return 0;//Edge case

        int[] dp = new int[n + 1];//dp Array for Bottom-Up

        //Initialization
        dp[0] = 0;
        dp[1] = 1;

        //Now Start Moving from i==2
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

```
