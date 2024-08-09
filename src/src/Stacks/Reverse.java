package Stacks;

import java.util.Stack;

public class Reverse {
    public static void recPushAtBottom(Stack<Integer>st,int top1){
        if(st.empty()){
            st.push(top1);//pushing to the bottom
            return;
        }
        int top=st.pop();
        recPushAtBottom(st,top1);
        st.push(top);

    }
    public static void pushAtBottom(Stack<Integer>st,int top){
        Stack<Integer>rt=new Stack<>();
        while(!st.empty()){
            rt.push(st.pop());
        }
        st.push(top);
        while(!rt.empty()){
            st.push(rt.pop());
        }

    }
    public static void recReverse(Stack<Integer>st){
        if(st.size()==1){
            return;
        }
        int top=st.pop();
        recReverse(st);
        recPushAtBottom(st,top);

    }
    public static void reverse(Stack<Integer> st){
        Stack<Integer>rt=new Stack<>();
        Stack<Integer>s=new Stack<>();
        while(!st.empty()){
            s.push(st.pop());
        }
        while(!s.empty()){
            rt.push(s.pop());
        }
        while(!rt.empty()){
            st.push(rt.pop());
        }
    }
    public static void main(String[]args){
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<5;i++){
            st.push(i);
        }

        System.out.println(st);
        reverse(st);
        System.out.println(st);

        recReverse(st);
        System.out.println(st);
    }
}
