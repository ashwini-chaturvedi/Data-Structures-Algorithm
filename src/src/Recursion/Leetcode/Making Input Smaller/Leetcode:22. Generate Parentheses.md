```java
//hame valid paranthesis generate krne h jisme n pairs of valid paranthesis rhe mtlb n open and n closing pranthesis

class Solution {

    public void makeBalanceParanthesis(int open, int close, String output, List<String> list) {
        if (open == 0 && close == 0) {            
            list.add(output);
            return;
        }else if (open==0 &&close != 0) {
                makeBalanceParanthesis(open, close - 1, output + ")", list);
                return;
        }

        if (open == close) {
            output += "(";
            makeBalanceParanthesis(open - 1, close, output, list);
        } else {
            String op1 = output + "(";
            String op2 = output + ")";

            makeBalanceParanthesis(open - 1, close, op1, list);
            makeBalanceParanthesis(open, close - 1, op2, list);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String output = "";
        makeBalanceParanthesis(n, n, output, list);
        return list;
    }
}

```
