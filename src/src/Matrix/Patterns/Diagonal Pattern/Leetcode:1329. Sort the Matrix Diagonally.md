```java
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: Group by diagonal
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int diff = i - j;
                map.putIfAbsent(diff, new ArrayList<>());
                map.get(diff).add(mat[i][j]);
            }
        }

        // Step 2: Sort each diagonal list in descending order (so we can pop smallest last)
        for (var e : map.entrySet()) {
            Collections.sort(e.getValue(), Collections.reverseOrder());
        }

        // Step 3: Refill the matrix (pop smallest element each time)
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int diff = i - j;
                List<Integer> list = map.get(diff);
                mat[i][j] = list.remove(list.size() - 1); // remove last element (smallest)
            }
        }

        return mat;
    }
}

```
