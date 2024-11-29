```java
class Solution {

    public void solve(String s, String output, List<String> list, Set<String> set, int idx) {
        if (idx >= s.length()) {
            list.add(output); //To remove blank spaces from prefix and suffix of the sentence...
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String subString = s.substring(idx, i + 1);
            if (set.contains(subString)) {
                String currSentence = output; //keeping backup for backtracking
                if (!output.isEmpty()) {
                    output += " ";
                }
                output += subString;//Including the substring so that we can make a Sentence
                solve(s, output, list, set, i+1);
                output = currSentence;//Backtracking
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);//add all the words in wordDict into set
        String output = "";
        solve(s, output, list, set, 0);
        return list;
    }
}

```
