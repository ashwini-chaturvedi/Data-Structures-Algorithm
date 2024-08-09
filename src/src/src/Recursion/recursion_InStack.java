package Recursion;

import java.util.Stack;

public class recursion_InStack {
   public static Stack<Integer>delete(Stack<Integer>st,int size){
        if(st.empty()){
            return st;
        }
        int midIdx=(size/2)+1;
        deleteMiddleElement(st,midIdx);
        return st;

    }
    public static void deleteMiddleElement(Stack<Integer>st,int currIdx){
        if(currIdx==1){
            st.pop();
            return;
        }
        int temp=st.pop();

        deleteMiddleElement(st,currIdx-1);
        st.push(temp);
    }
    //similar concept as sorting an array...
    //Smaller the Input method
    public static void sorting(Stack<Integer>st){
        if(st.size()==1){//base condition
            return;
        }
        int temp=st.pop();//Induction
        sorting(st);//hypothesis
        inserting(st,temp);//Induction again to attach the temp elements
    }
    public static void inserting(Stack<Integer>st,int temp){
        if(st.empty()||st.peek()<=temp){//Base Condition
            st.push(temp);
            return;
        }
        int tempVal=st.pop();//Induction
        inserting(st,temp);//Hypothesis
        st.push(tempVal);//again Induction
    }
    public static void main(String[]args){
        Stack<Integer>st=new Stack<>();
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        st.add(5);
        st.add(7);




        System.out.println(st);
        sorting(st);

        System.out.println(st);


        System.out.println(delete(st,st.size()));


    }
}
