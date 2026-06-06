```java
class Solution {
    //Here Prefix Sum Pattern= Precompute Left and Right
    //There is a Sense of Precompute left part:>= and the right part:<=
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        //Prefix:>=
        prefix[0] = 0;
        for (int i = 1; i < n; i++) {
            if (security[i - 1] >= security[i]) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = 0;
            }
        }

        //Suffix:<=
        suffix[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                suffix[i] = suffix[i + 1] + 1;
            } else {
                suffix[i] = 0;
            }
        }

        //Atlast if time we got is greater than time given in both the sides then we can rob this 
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (prefix[i] >= time && suffix[i] >= time) {
                list.add(i);
            }
        }

        return list;
    }
}

```
