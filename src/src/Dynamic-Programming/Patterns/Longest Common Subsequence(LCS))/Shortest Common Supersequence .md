```java
class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        //Find LCS
        int m = str1.length();
        int n = str2.length();

        int[][] topDown = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    topDown[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    topDown[i][j] = 1 + topDown[i - 1][j - 1];
                } else {
                    int includeX = topDown[i][j - 1];
                    int includeY = topDown[i - 1][j];

                    topDown[i][j] = Math.max(includeX, includeY);
                }
            }
        }

        //Retrieve the LCS Characters and also while doing this add those characters which do not match this will merge both Strings while keeping the LCS Element Frequency One

        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;

        //We Will Insert Elements at 0 because we are starting from bottom right of the topDown Matrix and going up to the topRight to get the LCS Element.

        //For Achieving SCS Just add Every Element you Encounter.
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.insert(0, str1.charAt(i - 1)); //add the Element if it is Matching
                i--;
                j--;
            } else {
                if (topDown[i - 1][j] > topDown[i][j - 1]) {
                    sb.insert(0, str1.charAt(i - 1)); //before going towards the cell which has maximum value Add the current Element if it is not matching
                    i--;
                } else {
                    sb.insert(0, str2.charAt(j - 1)); //before going towards the cell which has maximum value Add the current Element if it is not matching
                    j--;
                }
            }
        }

        //Now Insert the Remaining Elements
        while (i > 0) {
            sb.insert(0, str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.insert(0, str2.charAt(j - 1));
            j--;
        }

        return sb.toString();
    }
}

```
