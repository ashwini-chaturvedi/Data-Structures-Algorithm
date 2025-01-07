```java
class Solution {
    public int[] findLPS(String pattern) {
        int[] LPS = new int[pattern.length()];

        LPS[0] = 0;
        int i = 1;
        int maxLen = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(maxLen)) {
                maxLen++;
                LPS[i] = maxLen;
                i++;
            } else {
                if (maxLen != 0) {
                    maxLen = LPS[maxLen - 1];
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
        return LPS;
    }

    public int strStr(String haystack, String needle) {
        int[] LPS = findLPS(needle);//LPS for needle String

        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == needle.length()) {//when j is over the size of needle String
                return i - needle.length();//return the Starting of the String.
            } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = LPS[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
}
```
