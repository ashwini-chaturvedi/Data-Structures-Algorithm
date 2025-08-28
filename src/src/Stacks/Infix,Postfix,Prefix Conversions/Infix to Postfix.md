## Theory:
  1. Use a Stack of String and start traversing the String from 0th Index
  2. if current Character is an Operand add it to the Answer String 
  3. if current character is an Opening Parenthesis push it into the 
  stack
  4. if current character is an Closing Parenthesis start popping 
  elements from the stack and add it to the Answer String
  3. if we encounter an Operator 
          priority(ch)<=priority(st.peek())
      a) if operator on top of the stack is of lower priority 
      than current operator & not an Opening paranethesis then 
      push the current operator into the stack
      b) if operator on top of the stack is of higher or Equal priority 
      than current operator & not an Opening paranethesis 
      then start popping elements from the stack and adding it to 
      the Answer String until you get a lower priority operator 
      or opening bracket then push the current Operator into the stack.
  4. At last the whatever is left into the stack pop it and add it to 
  the Answer String.

*/
```java

class Solution {
    public static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='-' || ch=='+') return 1;
        else return -1;
    }
    public static String infixToPostfix(String s) {
        Stack<Character>st=new Stack();
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            
            char ch=s.charAt(i);
            
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')){
                sb.append(ch);
            }else if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                if(!st.isEmpty()){
                  st.pop();  
                }
                
            }else{
                while(!st.isEmpty()&& ch!='(' && priority(ch)<=priority(st.peek())){
                    sb.append(st.pop());
                }
                
                st.push(ch);
            }
        }
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.toString();
    }
    
}
```
