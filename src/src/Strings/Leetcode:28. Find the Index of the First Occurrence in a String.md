```java
class Solution {
    public int strStr(String haystack, String needle) {
        // If needle is empty, return 0 as specified by the problem
        if (needle.isEmpty()) return 0;
        
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        
        // Loop through haystack
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            int j = 0;
            // Check if substring matches needle
            while (j < needleLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // If we found a match, return starting index
            if (j == needleLen) {
                return i;
            }
        }
        // If no match found, return -1
        return -1;
    }
}
```
