 # Why Increasing Monotonic Stack?
   1.The Relative Order of the characters should also be maintained 
   2.we want to have smallest possible integer that is why Increasing Monotonic stack
 ```java
class Solution {
    //push the values in Increasing order...
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "" + 0;
        }

        Stack<Character> st = new Stack<>();
        int removed = 0;
        for (int i = 0; i < num.length(); i++) {
            while (!st.empty() && num.charAt(i) < st.peek() && removed < k) {//Push the Values only in increasing order into the stack
                st.pop();//Remove the Greater value which is in stack 
                removed++;
            }
            st.push(num.charAt(i));//Push the current value after removing the greater values so that stack can be Monotonic...
        }
        //removing letters from end
        while (removed < k) {
            st.pop();
            removed++;
        }
        StringBuilder ans = new StringBuilder();
        while (!st.empty()) {
            ans.insert(0, st.pop());
        }
        //deleting the leading zero numbers
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        return ans.toString();
    }
}

```
