```java
class Solution {

    public int[][] sortMatrix(int[][] grid) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int diff = i - j;
                map.putIfAbsent(diff, new ArrayList<>());

                map.get(diff).add(grid[i][j]);
            }
        }

        for (var e : map.entrySet()) {
            if (e.getKey() < 0) {
                Collections.sort(e.getValue(), Collections.reverseOrder());
            } else {
                Collections.sort(e.getValue());
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                List<Integer> list = map.get(i - j);
                grid[i][j] = list.remove(list.size() - 1);
            }
        }
        return grid;
    }
}

```
