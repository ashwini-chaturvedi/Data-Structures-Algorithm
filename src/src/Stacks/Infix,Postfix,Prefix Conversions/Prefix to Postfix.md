## Theory:

  #IMPORTANT: when you want the answer to be in Infix always keep one thing in Mind
      i) When converting prefix to anything start traversing from back.
      
      
  1. Use a Stack of String and start traversing the String from Last Index
  2. if current Character is an Operand push it into the stack.
  3. if we encounter and Operator 
      a) Make two pop operations
      b) Make the equation like this:

         top1 + top2 + ch
     
      c) push it back into the stack 
  5. At last the String into the Stack is the Infix Equation
```java


class Solution {
    static String preToPost(String s) {
         Stack<String>st=new Stack<>();
        
        for(int i=s.length()-1 ; i>=0;i--){
            char ch=s.charAt(i);
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')){
                st.push(ch+"");
            }else{
                String top1=st.pop();
                String top2=st.pop();
                
                String ans=top1+top2+ch;
                
                st.push(ans);
            }
        }
        return st.pop();
        
    }
}

```
