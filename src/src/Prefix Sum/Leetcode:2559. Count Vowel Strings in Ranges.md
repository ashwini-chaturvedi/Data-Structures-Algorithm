```java
class Solution {

    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> isVowel = new HashSet<>();
        isVowel.add('a');
        isVowel.add('e');
        isVowel.add('i');
        isVowel.add('o');
        isVowel.add('u');

        int[] prefix = new int[words.length];
        int i = 0;
        for (String word : words) {
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            if (isVowel.contains(first) && isVowel.contains(last)) {
                if (i == 0) {
                    prefix[i] = 1;
                } else {
                    prefix[i] = prefix[i - 1] + 1;
                }
            } else {
                if (i == 0) {
                    prefix[i] = 0;
                } else {
                    prefix[i] = prefix[i - 1];
                }
            }
            i++;
        }

        int[] ans = new int[queries.length];
        int k = 0;

        for (int[] query : queries) {
            int first = query[0];
            int last = query[1];

            int prefixFirst = 0;
            if (first != 0) {
                prefixFirst = prefix[first - 1];
            }
            int prefixLast = prefix[last];

            ans[k++] = prefixLast - prefixFirst;
        }

        return ans;
    }
}

```
