```java
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer>stackForOpenBracket=new Stack<>();
        Stack<Integer>stackForStar=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stackForOpenBracket.push(i);
            }else if(s.charAt(i)=='*'){
                stackForStar.push(i);
            }else{//if character is closeBracket
                if(!stackForOpenBracket.empty()){//Make Pair of Close Bracket with Open Bracket
                    stackForOpenBracket.pop();
                }else if(!stackForStar.empty()){//Make Pair of Close Bracket with Star.
                    stackForStar.pop();
                }else{//if no open bracket and start is present return false.
                    return false;
                }
            }
        }
        while(!stackForOpenBracket.empty()&&!stackForStar.empty()){
            if(stackForOpenBracket.peek()<stackForStar.peek()){//ACII Value of '(' is 72 && '*' is 74.
                stackForOpenBracket.pop();
                stackForStar.pop();
            }else{
                return false;
            }
        }
        return stackForOpenBracket.empty();
    }
}
```
