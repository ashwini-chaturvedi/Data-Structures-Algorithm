# Aproach:
## Sort the Array on the Basis of Price(index:0)
## then do a Cummulative Gathering of the Previous Maximum Beauty
## then do a Binary Search for each Query.
```java
class Solution {
    public int binarySearch(int[][] items, int target) {
        int res = -1;
        int low = 0;
        int high = items.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (items[mid][0] <= target) {//Only Update when the value is less than or equal to Target.
                res = Math.max(res, items[mid][1]);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res == -1 ? 0 : res;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        //Sorting the 2D Array on the Basis of value in 0th Index 
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
     

        //Make the Beauty Cummulative so that it always Aquires the Maximum Beauty Intended to
        //making the current beauty euqal to the Maximum beauty so far we Encountered this will make the current beauty as the maximum beauty we have so far seen...
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }

        //Then For each query do a Binary Search on it.
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = binarySearch(items, queries[i]);
        }
        return result;
    }
}
```
