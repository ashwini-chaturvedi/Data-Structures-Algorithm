Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
- s = "dababc", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".
Example 2:

Input: s = "axxxxyyyyb", part = "xy"
Output: "ab"
Explanation: The following operations are done:
- s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
- s = "axyb", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".

```java
class Solution {

    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int partLen = part.length();

        for (char ch : s.toCharArray()) {
            st.push(ch);

            // Check if the last `partLen` characters in stack form `part`
            if (st.size() >= partLen) {
                boolean match = true;
                for (int i = 0; i < partLen; i++) {
                    if (st.get(st.size() - partLen + i) != part.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    // Remove `partLen` characters from stack
                    for (int i = 0; i < partLen; i++) {
                        st.pop();
                    }
                }
            }
        }

        // Convert stack to result string
        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }
        return sb.toString();
    }
}

```
