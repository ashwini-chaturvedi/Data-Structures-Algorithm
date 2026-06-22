```java

class Solution {

    public void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public void generatePerm(List<Integer> list, int idx, int[] count) {
        if (idx == list.size()) {
            count[0]++;
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            swap(list, i, idx);
            int pos = idx + 1;
            int perm = list.get(idx);

            if (perm % pos == 0 || pos % perm == 0) {//Conditions.
                generatePerm(list, idx + 1, count);
            }

            swap(list, i, idx);
        }
    }

    public int countArrangement(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int[] count = { 0 };
        generatePerm(list, 0, count);

        return count[0];
    }
}

```
