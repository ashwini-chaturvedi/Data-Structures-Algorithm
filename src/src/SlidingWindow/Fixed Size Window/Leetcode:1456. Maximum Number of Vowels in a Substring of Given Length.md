Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3

Output: 3

Explanation: The substring "iii" contains 3 vowel letters.

```java
class Solution {

    public int maxVowels(String s, int k) {
        Set<Character> isVowel = new HashSet<>();

        isVowel.add('a');
        isVowel.add('e');
        isVowel.add('i');
        isVowel.add('o');
        isVowel.add('u');

        int i = 0;
        int j = 0;
        int ans = 0;
        int vowel = 0;

        while (j < s.length()) {
            if (isVowel.contains(s.charAt(j))) {
                vowel++;
            }

            if (j - i + 1 == k) {
                ans = Math.max(ans, vowel);
                if (isVowel.contains(s.charAt(i))) {
                    vowel--;
                }
                i++;
            }
            j++;
        }

        return ans;
    }
}

```
