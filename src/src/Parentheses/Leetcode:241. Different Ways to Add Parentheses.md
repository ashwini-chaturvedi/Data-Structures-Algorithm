```java
class Solution {

    public List<Integer> solve(String expression) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                //if the character is an Operator
                List<Integer> leftPart = solve(expression.substring(0, i));//Then Solve the left part of the Operator and the right Part of the Operator.
                List<Integer> rightPart = solve(expression.substring(i + 1));

                //Do the Operation on left and right part according to the Operator given.
                for (Integer left : leftPart) {
                    for (Integer right : rightPart) {
                        if (expression.charAt(i) == '+') {
                            list.add(left + right);
                        } else if (expression.charAt(i) == '-') {
                            list.add(left - right);
                        } else if (expression.charAt(i) == '*') {
                            list.add(left * right);
                        }
                    }
                }
            }
        }
        if (list.isEmpty()) {//Means there were no Operators Present and you just Simply Parse the String and Return the Number.
           list.add(Integer.parseInt(expression));
            return list;
        }
        return list;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
}

```
