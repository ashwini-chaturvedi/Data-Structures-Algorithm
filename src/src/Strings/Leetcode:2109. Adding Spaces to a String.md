```java
class Solution {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            //Each space should be inserted before the character at the given index.
            if (idx < spaces.length && spaces[idx] == i) {
                idx++;
                sb.append(" ");
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}

```
