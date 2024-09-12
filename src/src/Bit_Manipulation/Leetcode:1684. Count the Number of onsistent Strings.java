
class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;

        for (char ch : allowed.toCharArray()) {
            mask = mask | (1 << (ch - 'a'));
        }

        int count = 0;

        for (String word : words) {
            boolean flag = true;
            for (char ch : word.toCharArray()) {
                if (((mask >> (ch - 'a')) & 1) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
