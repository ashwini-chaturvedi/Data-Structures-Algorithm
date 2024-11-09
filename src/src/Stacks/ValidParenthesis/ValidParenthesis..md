```java
package Stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean valid(String str){
        int remove=0;
        Stack<Character>st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('){
                st.push(ch);
                remove++;
            }else{
                if(st.empty()){
                    System.out.println("Minimum number of things to remove:"+remove);
                    return false;
                }
                if(st.peek()=='('){
                    st.pop();
                    remove--;
                }
            }
        }
        if(!st.empty()){
            System.out.println("Minimum number of things to remove:"+remove);
            return false;
        }else{
            return true;
        }
    }
    public static void main(String[]args){
        String str=")()())";
        System.out.println(valid(str));
    }
}
```
