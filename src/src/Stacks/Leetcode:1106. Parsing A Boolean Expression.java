class Solution {
//Expression Question Must use Stack
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch==')') {//When found a Closing Bracket Start Evaluating the Expression.
                List<Character>exp=new ArrayList<>();
                while(st.peek()!='('){//add all the values from the stack into the list
                    exp.add(st.pop());
                }
                st.pop();//Remove '('
                char opr=st.pop();//Get the Operator
                
                char res='f';

                if(opr=='!'){
                    res=exp.get(0)=='t'?'f':'t';
                }else if(opr=='&'){
                    res=exp.contains('f')?'f':'t';//all must be true for equation to be true when using AND operator if any 'false' is in the equation it will give a 'false' as result.
                }else if(opr=='|'){
                    res=exp.contains('t')?'t':'f';//any one must be true for answer to be true when using OR operator 
                }
                st.push(res);
            }else if(ch==',') continue;//ignore the comma
            else{
                st.push(ch);
            }
        }
        return st.pop()=='t';
    }
}
