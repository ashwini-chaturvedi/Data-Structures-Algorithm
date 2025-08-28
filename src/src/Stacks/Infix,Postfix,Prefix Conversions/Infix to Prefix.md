## Theory:
  #IMPORTANT STEPS 
  
      i) Reverse the Infix Arrangement.  
      
      ii) traverse the Reverse String and change '('->')' & ')'->'('.    
      
      ii) Do Infix to Postfix Conversion with some Control     
      
      iii) Reverse the postfix Answer
      
  1. Reverse the String 
  2. Change the Opening Parenthesis to Closing and vice-versa
  3. Use a Stack of String and start traversing the String from 0th Index
  4. if current Character is an Operand add it to the Answer String 
  5. if current character is an Opening Parenthesis push it into the 
  stack
  5. if current character is an Closing Parenthesis start popping 
  elements from the stack and add it to the Answer String
  3. if we encounter an Operator 
      if(Operator =='^'){
      
          priority(ch)<=priority(st.peek())
      
     a) if operator on top of the stack is of lower priority 
      than current operator & not an Opening paranethesis then 
      push the current operator into the stack
      
      b) if operator on top of the stack is of higher or Equal priority 
      than current operator & not an Opening paranethesis 
      then start popping elements from the stack and adding it to 
      the Answer String until you get a lower priority operator 
      or opening bracket then push the current Operator into the stack.
      }else{
      
              priority(ch)<priority(st.peek())
              
              
     a) if operator on top of the stack is of lower priority 
      than current operator & not an Opening paranethesis then 
      push the current operator into the stack
     
      b) if operator on top of the stack is of higher priority 
      than current operator & not an Opening paranethesis 
      then start popping elements from the stack and adding it to 
      the Answer String until you get a lower priority operator 
      or opening bracket then push the current Operator into the stack.
      }
  5. At last the whatever is left into the stack pop it and add it to 
  the Answer String.
  6. Re-reverse the String.


```java

class Solution {
    public int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='-' || ch=='+') return 1;
        else return -1;
    }
    
    public String infixToPrefix(String s) {
       StringBuilder sb = new StringBuilder(s);
        
        sb.reverse();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==')'){
                sb.setCharAt(i,'(');
            }else if(sb.charAt(i)=='('){
                sb.setCharAt(i,')');
            }
        }
        
        
        
        Stack<Character> st=new Stack<>();
        
        StringBuilder ans=new StringBuilder();
        
        
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            
            
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')){
                ans.append(ch);
            }else if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans.append(st.pop());
                }
                
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                //if the operator is '^' then use <= else use <
                if(ch=='^'){
                    while(!st.isEmpty()&& ch!='(' && priority(ch)<=priority(st.peek())){
                        ans.append(st.pop());
                    }
                }else{
                     while(!st.isEmpty() && ch!='(' && priority(ch)<priority(st.peek())){
                    ans.append(st.pop());
                    }
                }
               
                st.push(ch);
            }
        }
        
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        
        ans.reverse();
        
        return ans.toString();
        
    }
}
```
