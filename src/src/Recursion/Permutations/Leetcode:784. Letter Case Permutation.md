```java
class Solution {

    public static List<String> solve(String input, String output, List<String> list, int idx) {
        if (idx == input.length()) {
            list.add(output);
            return list;
        }
        char ch = input.charAt(idx);
        if ((ch - '0') >= 0 && (ch - '0') <= 9) {//if the Character is a Number only put it as usual
            String op0 = output + ch;

            solve(input, op0, list, idx + 1);
        } else if ((ch - 'a') >= 0 && (ch - 'a') <= 25) {//if Character is a lowerCase letter try both way 
            // 1.in Small Letter 
            // 2.in Capital Letter 
            int ascii = (int) ch;
            char chars = (char) (ascii - 32);//Change to Upper case letter
            //Make Two Output: 1 for actual letter and Other for Upper Case letter
            String op1 = output + ch;
            String op2 = output + chars;
            //Call Function for Both types of Output
            solve(input, op1, list, idx + 1);
            solve(input, op2, list, idx + 1);
        } else if ((ch - 'A') >= 0 && (ch - 'A') <= 25) {//When Character is an UpperCase Letter
            int ascii = (int) ch;
            char chars = (char) (ascii + 32);//Change to Lower Case Letter
            //Make two Outputs
            String op1 = output + ch;
            String op2 = output + chars;
            
            solve(input, op1, list, idx + 1);
            solve(input, op2, list, idx + 1);
        }

        return list;
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        String output = "";
        return solve(s, output, list, 0);
    }
}

```
