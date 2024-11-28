we're using a stack to store indices rather than characters. Storing indices allows us to calculate the lengths of valid parentheses subsequences efficiently, which is essential for determining the longest valid sequence.
```java
class Solution {    
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) return 0;

        Stack<Integer> st = new Stack<>();
        st.push(-1);  // Base boundary to calculate lengths
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                st.pop();  // Match the current ')' with the last '('
                if (st.isEmpty()) {
                    st.push(i);  // Update boundary for unmatched ')'
                } else {
                    ans = Math.max(ans, i - st.peek());  // Update max length
                }
            } else {
                st.push(i);  // Push index of '(' onto the stack
            }
        }
        return ans;
    }
}

```
