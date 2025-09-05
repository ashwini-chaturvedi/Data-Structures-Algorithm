```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st=new Stack<>();

        for(String token:tokens){
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/") ){
                int top1=st.pop();
                int top2=st.pop();

                int res=0;
                if(token.equals("+")){
                    res=top2+top1;
                }else if(token.equals("-")){
                    res=top2-top1;
                }else if(token.equals("*")){
                    res=top2*top1;
                }else{
                    res=top2/top1;
                }

                st.push(res);
            }else{
                int num=Integer.parseInt(token);
                st.push(num);
            }
        }

        return st.pop();
    }
}
```
