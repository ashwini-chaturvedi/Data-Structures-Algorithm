You are given an integer n. Your task is to compute the GCD (greatest common divisor) of two values:

sumOdd: the sum of the smallest n positive odd numbers.

sumEven: the sum of the smallest n positive even numbers.

Return the GCD of sumOdd and sumEven.

 

Example 1:

Input: n = 4

Output: 4

Explanation:

Sum of the first 4 odd numbers sumOdd = 1 + 3 + 5 + 7 = 16

Sum of the first 4 even numbers sumEven = 2 + 4 + 6 + 8 = 20

Hence, GCD(sumOdd, sumEven) = GCD(16, 20) = 4.

```java
class Solution {
    public int gcd(int a,int b){
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }

        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }

        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int odd=(int)Math.pow(n,2);//formula to find n oddSum
        int even=n*(n+1);//formula to find n evenSum

        return gcd(odd,even);
    }
}
```
