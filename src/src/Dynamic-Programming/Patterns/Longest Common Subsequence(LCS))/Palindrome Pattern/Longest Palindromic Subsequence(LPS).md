```java
class Solution {

    public int longestPalindromeSubseq(String s) {
        //To Get 2nd String just get a String that is Reverse of first String.
        StringBuilder reversedS = new StringBuilder(s);
        reversedS.reverse();

        int m = s.length();
        int n = reversedS.length();

        int[][] topDown = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    topDown[i][j] = 0;
                } else if (s.charAt(i - 1) == reversedS.charAt(j - 1)) {
                    topDown[i][j] = 1 + topDown[i - 1][j - 1];
                } else {
                    int includeX = topDown[i][j - 1];
                    int includeY = topDown[i - 1][j];

                    topDown[i][j] = Math.max(includeX, includeY);
                }
            }
        }

        return topDown[m][n];
    }
}

```
