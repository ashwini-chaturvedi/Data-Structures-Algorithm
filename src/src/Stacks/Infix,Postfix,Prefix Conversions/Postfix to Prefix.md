## Theory:
  1. Use a Stack of String and start traversing the String from 0th Index
  2. if current Character is an Operand push it into the stack.
  3. if we encounter and Operator 
      a) Make two pop operations
      b) Make the equation like this:

         ch + top2 + top1

     
      c) push it back into the stack 
  5. At last the String into the Stack is the Infix Equation

```java


class Solution {
    static String postToPre(String s) {
        
        Stack<String>st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')){
                st.push(ch+"");
            }else{
                String top1=st.pop();
                String top2=st.pop();
                
                String ans=ch+top2+top1;
                
                st.push(ans);
            }
        }
        return st.pop();
        
    }
}

```
