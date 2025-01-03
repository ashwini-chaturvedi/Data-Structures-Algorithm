```java
class Solution {
    //ULTIMATE OPTIMIZATION...

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public int MCM(String s, int i, int j, int[][] memoiz) {
        if (i >= j) return 0;

        if (memoiz[i][j] != -1) {
            return memoiz[i][j];
        }

        if (isPalindrome(s, i, j)) {
            memoiz[i][j] = 0;//store the value in memoization when the String is palindrome
            return 0;
        }

        int minCuts = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            if (isPalindrome(s, i, k)) {//only proceed to check for right part when the left part is already a palindrome otherwise just mode to next cut because after all the recursive call on the left part if it is palindrome you don't have to check on left because the left part will always give value 0 
            //left part agar palindrome hoga toh woh 0 dega add krne ko aur left part ke palindrome hone ke baad hi check kro right part wrna dusre cut pe chle jao 
                int right = memoiz[k + 1][j] != -1 ? memoiz[k + 1][j] : MCM(s, k + 1, j, memoiz);
                memoiz[k + 1][j] = right;

                int tempAns =0+ 1 + right; //this 0 because left part is palindrome and it will give 0 as the answer after recursive call

                minCuts = Math.min(minCuts, tempAns);
            }
        }

        return memoiz[i][j] = minCuts;
    }

    public int minCut(String s) {
        int[][] memoiz = new int[s.length() + 1][s.length() + 1];

        for (int[] memo : memoiz) {
            Arrays.fill(memo, -1);
        }
        return MCM(s, 0, s.length() - 1, memoiz);
    }
}

```
