You are given a string s of length m consisting of digits. You are also given a 2D integer array queries, where queries[i] = [li, ri].

For each queries[i], extract the substring s[li..ri]. Then, perform the following:

Form a new integer x by concatenating all the non-zero digits from the substring in their original order. If there are no non-zero digits, x = 0.
Let sum be the sum of digits in x. The answer is x * sum.
Return an array of integers answer where answer[i] is the answer to the ith query.

Since the answers may be very large, return them modulo 109 + 7.

 

Example 1:

Input: s = "10203004", queries = [[0,7],[1,3],[4,6]]

Output: [12340, 4, 9]

Explanation:

s[0..7] = "10203004"
x = 1234
sum = 1 + 2 + 3 + 4 = 10
Therefore, answer is 1234 * 10 = 12340.
s[1..3] = "020"
x = 2
sum = 2
Therefore, the answer is 2 * 2 = 4.
s[4..6] = "300"
x = 3
sum = 3
Therefore, the answer is 3 * 3 = 9.

```java
class Solution {
    static long MOD = 1000000007;

    public long[] findSum(String s) {
        long[] res = new long[s.length()];
        res[0] = s.charAt(0) - '0';

        for (int i = 1; i < s.length(); i++) {
            res[i] = res[i - 1] + (s.charAt(i) - '0');
        }

        return res;
    }

    public long[] findPrefix(String s) {
        long[] res = new long[s.length()];
        res[0] = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                res[i] =( (res[i - 1] * 10) + s.charAt(i)-'0')%MOD;
            } else {
                res[i] = res[i - 1];
            }
        }

        return res;
    }

    public int[] findNonZeroUpto(String s) {
        int[] res = new int[s.length()];
        res[0] = s.charAt(0)  == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                res[i] = res[i - 1]+1;
            } else {
                res[i] = res[i - 1];
            }
        }

        return res;
    }

    public long[] findPow10(String s) {
        long[] res = new long[s.length()];
        res[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            res[i] = (res[i - 1] * 10)%MOD;
        }

        return res;
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        long[] sum = findSum(s);//hmesha substring keliye sum find krna h toh Precompute krke rkhlo
        long[] prefix = findPrefix(s);//hmesha substring me non-zero digits kitne honge usko precompute krke rkhlo
        int[] nonZeroUpto = findNonZeroUpto(s);//hrr index tkk non-zero numbers ka count kitna hoga yeh precompute krlo kyuki itni hi raise to power 10 krenge 
        long[] pow10 = findPow10(s);//Precompute power of 10 so that we can get answer in O(1)

        int[] res = new int[queries.length];
        int i = 0;

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = nonZeroUpto[r] - (l == 0 ? 0 : nonZeroUpto[l - 1]);//itne number of times power raise krenge taaki badi substring/number i.e.prefix[r] me se prefix[l-1] wala number hta ke l-r wala number/substring mil sake.i.e. prefix[r]=1234 and prefix[l-1]=12 now we want to get 34 from these two so,k=4-2=2=> hence 1234-12*10^2=34 we go l-r.

            long value;

            if (l == 0) {
                value = prefix[r];
            } else {//determining value
                value = (prefix[r] - (prefix[l - 1] * pow10[k]) % MOD + MOD) % MOD;
            }

            long sums;
            if (l == 0) {
                sums = sum[r];
            } else {//determining sum
                sums= (sum[r] - sum[l - 1]) % MOD;
            }
            res[i++] = (int)((value * sums) % MOD);
        }

        return res;
    }
}

```
