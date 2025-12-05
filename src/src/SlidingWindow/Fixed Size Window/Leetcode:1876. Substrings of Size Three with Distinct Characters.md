A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: s = "xyzzaz"

Output: 1

Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 

The only good substring of length 3 is "xyz".
```java
class Solution {

    public int countGoodSubstrings(String s) {
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;
        int count = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);
            while(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            if (j - i + 1 == 3) {
                count++;
                
                set.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return count;
    }
}

```
