```java
class Solution {

    public int minDifference(int nums[]) {
         int range = 0;
        for (int num : nums) {
            range += num;
        }

        boolean[][] topDown = new boolean[nums.length + 1][range + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < range + 1; j++) {
                if (i == 0) topDown[i][j] = false;
                if (j == 0) topDown[i][j] = true;
            }
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < range + 1; j++) {
                if (nums[i - 1] <= j) {
                    boolean include = topDown[i - 1][j - nums[i - 1]];
                    boolean exclude = topDown[i - 1][j];

                    topDown[i][j] = include || exclude;
                } else {
                    topDown[i][j] = topDown[i - 1][j];
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= range / 2; i++) {
            if (topDown[nums.length][i]) list.add(i);
        }

        return range - 2 * list.get(list.size() - 1);

    }
}
```
