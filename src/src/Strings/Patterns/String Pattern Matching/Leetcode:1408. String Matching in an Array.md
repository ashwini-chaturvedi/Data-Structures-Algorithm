# Bruteforce to find if one string is substring of another or use KMP algorithm.
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

    public boolean KMPalgo(String s, String pattern) {
        int[] LPS = findLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < s.length()) {
            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                return true;
            } else if (i < s.length() && s.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = LPS[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public List<String> stringMatching(String[] words) {
        Set<String>set=new HashSet<>();//To track the Duplicate Strings

        List<String> ans = new ArrayList<>();//to store the substring
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;//ignore the Self String

                String s = words[i];
                String pattern = words[j];

                //always make sure first String is the Greater String.
                if (s.length() >= pattern.length() && KMPalgo(s, pattern) && !set.contains(pattern)) {
                    ans.add(pattern);
                    set.add(pattern);
                } else if (s.length() < pattern.length() && KMPalgo(pattern, s) && !set.contains(s)) {
                    ans.add(s);
                    set.add(s);
                }
            }
        }

        return ans;
    }
}

```
