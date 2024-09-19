--------------------------------------Approach: Recursion(Choices-Decision)------------------------------------
if there are Choices take them or leave them Decision taking Pattern
We Split the Left and Right of the Expression in two parts as we Encounter any Operator like('+','-','*') 
after that we calculate or process the left and right Parts of the Expression Individually and Later on 
we just do according to the Operator at which the Expression was Split in two parts.


--------------------------------------->Recursion + Two Pointer Approach<------------------------------------
class Solution {

    public List<Integer> solve(String expression, int low, int high) {
        List<Integer> list = new ArrayList<>();

        for (int i = low; i < high; i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                List<Integer> leftPart = solve(expression, low, i);
                List<Integer> rightPart = solve(expression, i + 1, high);

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
        if (list.isEmpty()) {
            // This will act as Base Case after all the loop is Ended and only Expression is left just Parse it and return it.
            list.add(Integer.parseInt(expression.substring(low, high)));
            return list;
        }
        return list;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression, 0, expression.length());
    }
}

--------------------------------------->Substring Approach<----------------------------------------------
class Solution {

    public List<Integer> solve(String expression) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                List<Integer> leftPart = solve(expression.substring(0, i));
                List<Integer> rightPart = solve(expression.substring(i + 1));

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
        if (list.isEmpty()) {
           list.add(Integer.parseInt(expression));
            return list;
        }
        return list;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
}

