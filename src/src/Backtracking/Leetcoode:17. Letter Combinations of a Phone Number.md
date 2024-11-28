```java
class Solution {

    public void solve(String digits, List<String> list, StringBuilder ans, Map<Integer, String> map, int idx) {
        if (idx == digits.length()) {
            if (ans.length() == digits.length()) {//Combination should be same as the digits because every key when press should include some character
                list.add(ans.toString());
            }
            return;
        }

        int currIdx = digits.charAt(idx) - '0';//get the number that is pressed in phone
        String str = map.get(currIdx);//String of Characters associated with that number

        for (int i = idx; i < digits.length(); i++) {
            for (int j = 0; j < str.length(); j++) {//Use all the characters to form the combinations
                ans.append(str.charAt(j));
                solve(digits, list, ans, map, i + 1);
                ans.deleteCharAt(ans.length() - 1);//Backtracking
            }
        }
    }

    public List<String> letterCombinations(String digits) {
//Store the Key to Character Combination in a Map
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        StringBuilder ans = new StringBuilder();// using StringBuilder instead of List<String> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {

            return list;
        }
        solve(digits, list, ans, map, 0);

        return list;
    }
}

```
