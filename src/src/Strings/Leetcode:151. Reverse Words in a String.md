```java
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
         // \\s in regex means “any whitespace character” (space, tab, newline).
        //+ means “one or more of the preceding thing”.
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }

        return sb.toString().trim();
    }
}

```
