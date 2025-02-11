You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

 

Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.

Example 2:

Input: s = "cb34"

Output: ""

Explanation:

First, we apply the operation on s[2], and s becomes "c4".

Then we apply the operation on s[1], and s becomes "".

```java
class Solution {
    //First we traverse the String when we find a Digit then we mark it toBeDeleted as true and then traverse back to the left side to a Character and if we found one we mark it true and atlast we construct the Answer.

    public String clearDigits(String s) {
        int n = s.length();
        boolean[] toBeDeleted = new boolean[n];//To store the indices of that should be deleted.

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {//if the character is a Digit
                toBeDeleted[i] = true;//Mark it true i.e. it will be deleted
                for (int j = i; j >= 0; j--) {
                    if (Character.isLetter(s.charAt(j)) && !toBeDeleted[j]) {//if the character is a Letter and it is not previously marked as true means it was not paired with any other digit.
                        toBeDeleted[j] = true;//mark it true or make it pair with the digit
                        break;
                    }
                }
            }
        }

        //Construct the Answer.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!toBeDeleted[i]) {//if the Index is not marked toBeDeleted then include Character at from that Index.
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

```
