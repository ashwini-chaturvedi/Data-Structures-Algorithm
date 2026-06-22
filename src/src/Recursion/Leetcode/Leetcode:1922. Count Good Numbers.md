```java
class Solution {

    static final long MOD = 1000000007;

    public long power(long x, long n) {
        long result = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * x) % MOD;
            }

            x = (x * x) % MOD;
            n >>= 1;
        }

        return result;
    }

    public int countGoodNumbers(long n) {

        long evenPositions = (n + 1) / 2;
        long primePositions = n / 2;

        long evens = power(5, evenPositions);
        long primes = power(4, primePositions);

        return (int)((evens * primes) % MOD);
    }
}
```
