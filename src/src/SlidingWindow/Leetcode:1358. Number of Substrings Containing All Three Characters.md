Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1

```java
class Solution {
    public int numberOfSubstrings(String s) {
        int[] occurence = new int[3]; // Array to track occurrences of 'a', 'b', and 'c'
        int i = 0; // Left pointer
        int j = 0; // Right pointer
        int n = s.length(); // Length of the input string
        int result = 0; // Variable to store the final count of substrings

        while (j < s.length()) {
            // Increment count of the current character in the occurrence array
            occurence[s.charAt(j) - 'a']++;

            // Check if all three characters 'a', 'b', and 'c' are present in the current window
            while (occurence[0] > 0 && occurence[1] > 0 && occurence[2] > 0) {

                /*----------------IMPORTANT---------------- */
                // If valid, add all substrings that can be formed by extending the right pointer
                result += (n - j); // Total occurrences of valid substrings up to 'j' is (n - j)

                // Move the left pointer forward and update the occurrence count
                occurence[s.charAt(i) - 'a']--;
                i++;
            }

            // Expand the window by moving the right pointer forward
            j++;
        }

        return result; // Return the total count of valid substrings
    }
}

```
