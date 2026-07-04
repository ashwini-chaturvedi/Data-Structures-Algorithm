Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"

Output: 10

Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

```java
class Solution {
    public int numberOfSubstrings(String s) {
        int[] occur=new int[3];
        int i=0;
        int j=0;
        int count=0;

        while(j<s.length()){
            occur[s.charAt(j)-'a']++;

            while(i<j && occur[0]>=1 && occur[1]>=1 && occur[2]>=1){
                count+=(s.length()-j);//valid subsets from i to n 

                occur[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return count;
       
    }
}
```
