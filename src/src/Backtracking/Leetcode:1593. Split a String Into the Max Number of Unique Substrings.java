class Solution {

    public void solve(String s, int idx, int[] maxSplit, Set<String> set, int currSplit) {
        //Base Case:
        if (idx == s.length()) {
            maxSplit[0] = Math.max(maxSplit[0], currSplit);//Maximum Split
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            String currSubStr = sb.toString();

            if (!set.contains(currSubStr)) {
                set.add(currSubStr);
                solve(s, i + 1, maxSplit, set, currSplit + 1); //we have split it into one more piece
                set.remove(currSubStr);//Backtrack
            }
        }
    }

    public int maxUniqueSplit(String s) {
        int[] maxSplit = { 0 };
        Set<String> set = new HashSet<>();

        solve(s, 0, maxSplit, set, 0);
        return maxSplit[0];
    }
}
