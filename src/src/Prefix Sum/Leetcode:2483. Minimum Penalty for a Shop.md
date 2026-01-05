```java
class Solution {

    public void display(int[] arr) {
        for (int num : arr) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                prefix[i]++;
            }
        }

    
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];
            if (customers.charAt(i) == 'Y') {
                suffix[i]++;
            }
        }

        display(prefix);
        display(suffix);

        int res = 0;
        int minPenalty = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            int penalty = prefix[i] + suffix[i];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                res = i;
            }
        }

        return res;
    }
}

```
