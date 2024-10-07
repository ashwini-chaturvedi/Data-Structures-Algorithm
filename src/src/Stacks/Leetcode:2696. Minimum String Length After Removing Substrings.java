class Solution {
//We have to Remove substring:AB or CD 
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if ((ch == 'B' && !st.isEmpty() && st.peek() == 'A') || (ch == 'D' && !st.isEmpty() && st.peek() == 'C')) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        return st.size();
    }
}
