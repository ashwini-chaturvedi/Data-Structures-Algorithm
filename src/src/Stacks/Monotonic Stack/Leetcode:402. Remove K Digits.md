 # Why Increasing Monotonic Stack?
   1.The Relative Order of the characters should also be maintained 
   
   2.we want to have smallest possible integer that is why Increasing Monotonic stack

```java
class Solution {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Stack<Character> st = new Stack<>();
        st.push(num.charAt(0));
        int i = 1;
        for (; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!st.isEmpty() && (st.peek() - '0') > (ch - '0') && k > 0) {
                st.pop();
                k--;
            }
       
            st.push(ch);
        }


        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        if (k > 0) {
            sb = new StringBuilder(sb.substring(0, sb.length() - k));
        }

        StringBuilder s = new StringBuilder();
        boolean isFound = false;
        for (char ch : sb.toString().toCharArray()) {
            if ((ch - '0') != 0) {
                s.append(ch);
                isFound = true;
            } else if (isFound) {
                s.append(ch);
            } else {
                continue;
            }
        }

        

        return s.toString().isEmpty() ? "0" : s.toString();
    }
}

```
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
