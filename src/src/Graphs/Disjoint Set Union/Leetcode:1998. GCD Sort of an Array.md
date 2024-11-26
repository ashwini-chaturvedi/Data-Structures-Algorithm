# GCD and Prime Factors:
  >Numbers that share a common factor (e.g., 2, 3, or other primes) can form a connected group because they can swap with each other directly or indirectly.

# Why Prime Factors?
  >Any number can be broken down into its prime factors, and any number sharing at least one prime factor with another number is connected.
  >Using these prime factors, we group numbers together via union.
```java
class Solution {

    public int find(int x, int[] Parents) {
        if (x == Parents[x]) return x;

        return Parents[x] = find(Parents[x], Parents);
    }

    public void Union(int x, int y, int[] Parents, int[] Rank) {
        int ParentX = find(x, Parents);
        int ParentY = find(y, Parents);

        if (ParentX == ParentY) return;

        if (Rank[ParentX] > Rank[ParentY]) {
            Parents[ParentY] = ParentX;
        } else if (Rank[ParentX] < Rank[ParentY]) {
            Parents[ParentX] = ParentY;
        } else {
            Parents[ParentY] = ParentX;
            Rank[ParentX]++;
        }
    }

    // Main Method
    public boolean gcdSort(int[] nums) {
        int maxVal = -1;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] Parents = new int[maxVal + 1];
        int[] Rank = new int[maxVal + 1];
        for (int i = 0; i < maxVal + 1; i++) {
            Parents[i] = i;
        }

        for (int num : nums) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    Union(num, factor, Parents, Rank);
                    Union(num, num / factor, Parents, Rank);
                }
            }
            if (num > 1) Union(num, num, Parents, Rank);//For Prime Number
        }

        int[] possibleSortedNums = nums.clone(); //Clone of the nums
        Arrays.sort(possibleSortedNums);

        //For the original array (nums) to be sortable, each number in nums must belong to the same group (connected component) as its position in the sorted array.
        for (int i = 0; i < nums.length; i++) {
            if (find(nums[i], Parents) != find(possibleSortedNums[i], Parents)) {
                return false;
            }
        }
        return true;
    }
}

```
