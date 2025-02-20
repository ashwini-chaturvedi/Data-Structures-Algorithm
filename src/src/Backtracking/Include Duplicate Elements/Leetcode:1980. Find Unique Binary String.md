Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

 

Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
Example 2:

Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.
Example 3:

Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.

```java
class Solution {
//Generate all the Occurences of the String s.
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

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        String s = "01";//Binary String
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        solve(s, sb, list, n);//Backtracking

        Set<String> set = new HashSet<>();//Store all the Occurences in a set and then traverse the list of all the occurences and the string which is not present in nums return it.
        for (String num : nums) {
            set.add(num);
        }

        for (String str : list) {
            if (!set.contains(str)) {
                return str;
            }
        }
        return "";
    }
}


```
