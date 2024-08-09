package Stacks;
import java.util.*;

public class Basics {

    public static void reverseDisplayRecursively(Stack<Integer>st){
        if(st.empty()){
            return;
        }
        int top=st.pop();
        System.out.print(top+",");
        reverseDisplayRecursively(st);//Recursive call
        st.push(top);//again pushing allPathFromStoT the elements in stack so that our stack remain as it was...
    }
    public static void copy(Stack<Integer>st,Stack<Integer> res){
        if(st.empty()){
            return;
        }

       res.push(st.pop());
        copy(st,res);
       return;

    }
    public static void main(String[]args){
        Stack<Integer> st=new Stack<>();
        st.push(32);
        st.push(90);
        st.push(3);
        st.push(0);
        st.push(2);
        st.push(9);

//
//       int []arr=new int[st.size()];
//       for(int i=0;i<arr.length;i++){
//           arr[i]=st.pop();
//       }
//       int j=arr.length-1;
//       while(j>=0){
//           System.out.println(arr[j]);
//           j--;
//       }
        System.out.println(st);
//       //copying the stack
//        Stack<Integer>res=new Stack<>();
//        copy(st,res);
//        System.out.println(res);
//        reverseDisplayRecursively(st);




    }
}
