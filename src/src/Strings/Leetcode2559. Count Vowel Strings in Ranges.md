```java
class Solution {

    public boolean isGood(String s, Set<Character> isVowel) {
        return isVowel.contains(s.charAt(0)) && isVowel.contains(s.charAt(s.length() - 1));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> isVowel = new HashSet<>();
        isVowel.add('a');
        isVowel.add('e');
        isVowel.add('i');
        isVowel.add('o');
        isVowel.add('u');

        // Precompute the prefix sum of strings that start and end with vowels.
        //har string se pehle kitne good String h uska count store krlo
        int[] prefix = new int[words.length + 1];//Take a one length greater Array so that you don't have to manage -1 index for prefix
        int k = 1;

        for (String s : words) {            
            prefix[k]=isGood(s,isVowel)?1 + prefix[k - 1]: prefix[k - 1];
            k++;
        }
        int[] res = new int[queries.length];
        int idx = 0;

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            res[idx] = prefix[end+1] - prefix[start];//beacuse we have taken one size greater array so increase the end because for end string the count of its prefix will be one index plus.
            idx++;
        }
        return res;
    }
}

```
