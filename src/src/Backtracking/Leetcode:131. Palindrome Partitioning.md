```java
class Solution {

    public boolean isPalindrome(String s, int idx, int i) {
        while (idx <= i) {
            if (s.charAt(idx) != s.charAt(i)) {
                return false;
            }
            idx++;
            i--;
        }

        return true;
    }

    public void solve(String s, List<List<String>> list, List<String> ans, int idx, int length) {
        if (idx == length) {
            list.add(new ArrayList<>(ans));
        }
        for (int i = idx; i < length; i++) {
            if (isPalindrome(s, idx, i)) {//check for valid Palindrome and then only include the String between idx to i
                ans.add(s.substring(idx, i + 1));//i+1 because we want to have the characters from idx to i both inclusive but substring method will exclude the char at end point so that is why i+1 so that it will include String b/w idx to i
                solve(s, list, ans, i + 1, length);
                ans.remove(ans.size() - 1);//Backtracking
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int length = s.length();
        solve(s, list, ans, 0, length);
        return list;
    }
}


```
