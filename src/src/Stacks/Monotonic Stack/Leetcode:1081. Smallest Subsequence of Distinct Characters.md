Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

 Same as: [Link]()

Example 1:

Input: s = "bcabc"

Output: "abc"

# My-Approach
```java
class Solution {

    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        //Count the Frequency of the characters.
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int[] frqAns = new int[26];//to store the frequency of the characters that are in the Answer.
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (!st.isEmpty() && (st.peek() - 'a') >= (ch - 'a') && freq[st.peek() - 'a'] >= 1 && frqAns[ch - 'a'] < 1) {
                //if stack is not empty ans st's top-most character is greater than equal to the current character and frequency of the topmost character of the stack is greater then equal to 1 signifying that this character is still present in later array and the currentCharacter is not present in the answer so it is compulsory to store this in answer ans hence we pop from stack and decrease the frequency in the Answer.
                char c = st.pop();
                frqAns[c - 'a']--;
            }

            if (frqAns[ch - 'a'] < 1) {//if current character is not present in the answer then include it
                st.push(ch);
                frqAns[ch - 'a']++;
            }
            freq[ch - 'a']--; //element is used now
        }

        //final answer is in stack and then we pop from it and inlcude it.
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
```

# CodeStoryOfMIK Approach
```java
class Solution {

    public String smallestSubsequence(String s) {
        int[] lastOccurIdx = new int[26]; //why? because we want to know that if this index will come in later stages or not if it is going to come then just remove it from now and later we'll get it to know that this character can be find later.

        //Store the lastOccurenceIndex of the character.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastOccurIdx[ch - 'a'] = i;
        }

        //store the true/false of the character in answer.
        boolean[] inAns = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (!st.isEmpty() && (st.peek() - 'a') >= (ch - 'a') && lastOccurIdx[st.peek() - 'a'] > i && inAns[ch - 'a'] == false) {
                //if stack is not empty and topmost character in stack is greater than current character and lastOccurenceIndex of the topmost character is greater then current Index indicating that this character can be found in later stages and the current Character is not present in the answer.
                char c = st.pop();
                inAns[c - 'a'] = false;
            }

            if (!inAns[ch - 'a']) {//if current character is not present in the answer then put it as true.
                inAns[ch - 'a'] = true;
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}

```
