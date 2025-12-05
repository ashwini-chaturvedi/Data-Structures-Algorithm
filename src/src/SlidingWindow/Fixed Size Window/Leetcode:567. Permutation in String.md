Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"

Output: true

Explanation: s2 contains one permutation of s1 ("ba").

```java
class Solution {

    public boolean checkAllZero(int[] arr) {
        for (int num : arr) {
            if (num != 0) return false;
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];

        for (char ch : s1.toCharArray()) {
            arr[ch - 'a']++;
        }

        int i = 0;
        int j = 0;

        while (j < s2.length()) {
            char ch = s2.charAt(j);
            arr[ch - 'a']--;

            if (j - i + 1 == s1.length()) {
                if (checkAllZero(arr)) {
                    return true;
                }
                arr[s2.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return false;
    }
}

```
