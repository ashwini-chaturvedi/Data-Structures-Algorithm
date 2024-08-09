package Stacks;

import java.util.Stack;

public class decodeString {
    public static String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        Stack<Integer>counts = new Stack<>();
        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < s.length()) {
            StringBuilder digit = new StringBuilder();
            if (Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    digit.append(s.charAt(i));
                    i++;
                }
                int count = digit.length()>0 ? Integer.parseInt(digit.toString()) : 1;
                counts.push(count);
            }else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while (st.peek() != '[') {
                    sb.insert(0, st.pop());
                }
                st.pop();
                int n=counts.pop();
                for (int j = 0; j < n; j++) {
                    result.append(sb.toString());
                }
                i++;
            } else {
                st.push(s.charAt(i));
                i++;
            }
        }
        StringBuilder sbr=new StringBuilder();
        while(!st.isEmpty()){
            sbr.insert(0,st.pop());
        }
        return result.toString()+sbr.toString();
    }
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.print(decodeString(s));
    }
}
