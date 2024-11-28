# Using String Tokenizer
```java
import java.util.StringTokenizer;

class Solution {
    public int compareVersion(String version1, String version2) {
        StringTokenizer tokens1 = new StringTokenizer(version1, ".");
        StringTokenizer tokens2 = new StringTokenizer(version2, ".");

        while (tokens1.hasMoreTokens() || tokens2.hasMoreTokens()) {
            // Parse the current tokens as integers, default to 0 if no more tokens.
            int num1 = tokens1.hasMoreTokens() ? Integer.parseInt(tokens1.nextToken()) : 0;
            int num2 = tokens2.hasMoreTokens() ? Integer.parseInt(tokens2.nextToken()) : 0;

            // Compare the current numbers
            if (num1 > num2) {
                return 1; // version1 is greater
            } else if (num1 < num2) {
                return -1; // version2 is greater
            }
        }

        // Versions are equal
        return 0;
    }
}

```
