```java
class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <=rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1); // first and last element of each row is 1
                } else {
                    row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j)); 
                }
            }
            list.add(row);
        }

        if (rowIndex == 0) {
            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            return ans;
        }

        return list.get(rowIndex );
    }
}

```
