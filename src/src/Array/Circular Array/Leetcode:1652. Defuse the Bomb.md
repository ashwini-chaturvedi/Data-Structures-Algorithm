```java
class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) return new int[code.length];

        int[] res = new int[code.length];

        for (int idx = 0; idx < code.length; idx++) {
            int sum = 0;
            if (k > 0) {
                for (int i = 1; i <= k; i++) {
                    sum += code[(idx + i + code.length) % code.length]; //Traversal of a circular array. forward Traversal
                }
            } else if (k < 0) {
                for (int i = 1; i <= -k; i++) {
                    sum += code[(idx - i + code.length) % code.length]; //Backward Traversal
                }
            }
            res[idx] = sum;
        }
        return res;
    }
}

```
