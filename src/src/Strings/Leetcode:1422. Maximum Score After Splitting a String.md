```java
class Solution {

    public int maxScore(String s) {
        int zeros = 0;
        int ones = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') ones++;//Count number of zeros
        }
        int Score = 0;
//Atleast 1 mimimum Split is Necesary so start from index 1 and take decision for character at 0.
        if (s.charAt(0) == '0') {
            zeros += 1;
        } else {
            ones -= 1;
        }

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            Score = Math.max(Score, zeros + ones);//Calculate the Maximum Score

            if (ch == '0') {
                zeros += 1;
            } else {
                ones -= 1;
            }
        }
        return Score;
    }
}

```
