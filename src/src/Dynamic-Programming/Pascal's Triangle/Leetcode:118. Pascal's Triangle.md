```java
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>list=new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
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

        return list;
    }
}
```
