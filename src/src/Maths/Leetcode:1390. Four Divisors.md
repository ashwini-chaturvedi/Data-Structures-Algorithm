```java
class Solution {

    public int sumDivisor(int n) {
        int sum = 1 + n;
        int count = 2;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) { 
                    count += 1;
                    sum += i;
                } else {
                    count += 2;
                    sum += i + (n / i);
                }

                if (count > 4) return 0;
            }
        }
        return count == 4 ? sum : 0;
    }

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += sumDivisor(num);
        }

        return sum;
    }
}

```
