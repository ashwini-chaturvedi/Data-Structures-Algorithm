A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

 

Example 1:

Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
Example 2:

Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.
Example 3:

Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"

```java
class Solution {
    //Find all Permutations for a String
    public void solve(String s, StringBuilder sb, List<String> res, int n) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return; // Stop recursion at length `n`
        }

        for (int i = 0; i < s.length(); i++) {//always start from zero index because occurences of the duplicate element is allowed.
            sb.append(s.charAt(i));
            solve(s, sb, res, n);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
    }

    public boolean isValid(String s) {//s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) return false;
        }
        return true;
    }

    public String getHappyString(int n, int k) {
        String s = "abc";//Main String
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();

        solve(s, sb, res, n);

        List<String> happyStrings = new ArrayList<>();
        for (String str : res) {
            if (isValid(str)) {//Checking the Validity
                happyStrings.add(str);
            }
        }
        Collections.sort(happyStrings);//Sort the String

        return k <= happyStrings.size() ? happyStrings.get(k - 1) : "";//String Size 
    }
}

```
