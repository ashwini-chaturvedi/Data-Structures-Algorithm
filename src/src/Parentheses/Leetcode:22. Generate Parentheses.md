```java
class Solution {
    // Helper function to recursively generate valid parenthesis combinations
    public List<String> solve(int open, int close, String output, List<String> list) {
        // Base case: When no more open or close parentheses can be added
        if (open == 0 || close == 0) {
            // If there are still closing parentheses remaining, add them
            if (close != 0) {
                String op4 = output + ")"; // Add a closing parenthesis
                solve(open, close - 1, op4, list); // Decrement the number of closing parentheses
                return list; // Return the list (important for early termination)
            }
            // If both open and close are 0, we have a valid combination
            list.add(output); // Add the generated combination to the list
            return list; // Return the list
        }

        // If the number of open and close parentheses is equal
        if (open == close) {
            // closing Parenthesis only comes in a pair with the opening Parenthesis
            // Add an opening parenthesis since closing cannot come before an opening
            String op1 = output + "(";
            solve(open - 1, close, op1, list); // Decrement the number of opening parentheses
        } else {
            // If open != close, we can either add an opening or closing parenthesis
            String op2 = output + "("; // Option 1: Add an opening parenthesis
            String op3 = output + ")"; // Option 2: Add a closing parenthesis
            solve(open - 1, close, op2, list); // Explore the branch with one fewer opening
            solve(open, close - 1, op3, list); // Explore the branch with one fewer closing
        }

        return list; // Return the list (after exploring all possibilities)
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>(); // List to store all valid combinations
        String output = ""; // Start with an empty string
        int open = n; // Initialize the number of open parentheses to `n`
        int close = n; // Initialize the number of close parentheses to `n`
        return solve(open, close, output, list); // Start the recursive process
    }
}

```
