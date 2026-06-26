Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 

Example 1:

Input: s = "a1b2"

Output: ["a1b2","a1B2","A1b2","A1B2"]

# Solution:

XORing a Character with 32 changes it b/w Upper case and Lower Case.

beacuse 

        'A' = 65  = 01000001
        'a' = 97  = 01100001
              32  = 00100000
        
  The 6th bit determines whether a letter is uppercase or lowercase.
  
  so,
  
        'A' = 01000001
        32  = 00100000
        ---------------- XOR
             01100001 = 'a'

  hence,
  
        char ch = 'A';
        ch ^= 32;   // becomes 'a'
    
```java
class Solution {
    public void solve(char[] s, List<String> list, int idx) {
        if (idx == s.length) {
            list.add(new String(s));
            return;
        }

        solve(s,list,idx+1);
    
        if (Character.isAlphabetic(s[idx])) {
            s[idx]^=32;//toggle the character from lower to upper and vice-versa          

            solve(s,list,idx+1);

            s[idx]^=32;
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();

        solve(s.toCharArray(), list, 0);

        return list;
    }
}

```
