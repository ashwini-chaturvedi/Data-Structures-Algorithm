package Strings;

import java.util.Stack;

public class reverserStringBetweenParenthesis {
    public static void reverserAndAdd(Stack<Character>st){
        StringBuilder sb=new StringBuilder();
        while(st.peek()!='('){
           sb.append(st.pop());
        }
        st.pop();
        for(int i=0;i<sb.length();i++){
            st.push(sb.charAt(i));
        }
    }
    public static void main(String[] args) {
        String s="(ni(pc(do))ep)g";
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch==')') {
                reverserAndAdd(st);
            }else{
                st.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        int size=st.size();
        for(int i=0;i<size;i++){
            sb.insert(0,st.pop());
        }
        System.out.println(sb);
    }
}
