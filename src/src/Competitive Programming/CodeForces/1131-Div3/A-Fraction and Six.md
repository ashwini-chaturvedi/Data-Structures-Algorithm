You are given two strings p and q, consisting of lowercase English letters.

Interpret the string p as the product of variables written in the numerator of a fraction, and the string q as the product of variables written in the denominator. Each character represents a variable.

Since multiplication is commutative, the variables in both the numerator and the denominator may be reordered arbitrarily. In addition, any variable that appears in both the numerator and the denominator may be cancelled. Note that a single occurrence of a variable in the denominator can only cancel exactly one occurrence of that variable in the numerator and vice versa.

Determine whether it is possible to simplify the fraction so that the resulting expression is exactly equal to the string six. In other words, after performing any number of cancellations and rearrangements, the remaining variables in the numerator must form the string six, and no variables may remain in the denominator.

For example, if p=sinx and q=n, then the variable n can be cancelled, leaving six in the numerator.

![](https://espresso.codeforces.com/1ac4929438e4908210cb2bb8872c7d6702fcd18f.png)

Input:

The first line of the input contains a single integer t (1≤t≤100) — the number of test cases. The description of each test case follows.

The first line of each test case contains two integers n and m (1≤n,m≤100) — the lengths of the strings p and q, respectively.

The second line of each test case contains a string p denoting the numerator of the fraction. It is guaranteed that the length of the string p is equal to n and that it contains only lowercase English letters.

The third line of each test case contains a string q denoting the denominator of the fraction. It is guaranteed that the length of the string q is equal to m and that it contains only lowercase English letters.

Output:

For each test case, print "YES" if you can simplify the fraction so that the resulting expression is exactly equal to the string six and "NO" otherwise.

You can output "YES" and "NO" in any case (for example, strings "yEs", "yes" and "Yes" will be recognized as a positive response).

Example:

Input
t=5

{(4 1 sinx n),(6 7 xixsms mixsxim),(8 5 fixtures frute),(3 3 abc def),(5 10 sixty codeforces)}

Output:

[YES,NO,,YES,NO,NO]

```java

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();

            if (line == null) {
                throw new EOFException();
            }

            st = new StringTokenizer(line);
        }

        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static void solve() throws IOException {

        int n = nextInt();
        int m = nextInt();

        String p=next();
        String q=next();


        if(isFeasible(p,q)){
            sb.append("Yes"+"\n");
        }else{
            sb.append("No"+"\n");
        }

    }

    static boolean isFeasible(String p,String q){
        int[] counter=new int[26];

      // Increase the Counter for characters in p
        for(char ch:p.toCharArray()){
            counter[ch-'a']++;
        }
      //Now Decrease the Counter for characters in q
        for(char ch:q.toCharArray()){
            counter[ch-'a']--;
        }

      // Now Traverse the Counter Array and if the index's character representation is either 's','i','x'  and also there count should be 1.
        for (int i = 0; i < 26; i++) {

            char ch = (char) ('a' + i);

            if (ch == 's' || ch == 'i' || ch == 'x') {
                if (counter[i] != 1) return false;
            } else {
                if (counter[i] != 0) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {

        int t = nextInt();

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {
            solve();
        }

        System.out.println(sb);
    }


}
```
