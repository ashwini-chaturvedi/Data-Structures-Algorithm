Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k. You may return the answer in any order.

Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.

 

Example 1:

Input: n = 3, k = 7

Output: [181,292,707,818,929]

Explanation: Note that 070 is not a valid number, because it has leading zeroes.

```java
class Solution {
    public boolean isValid(int num, int i, int k) {
        if (num==0 && i == 0) {
            return false;
        } else if (num==0) return true;

        int last = num%10;

        return Math.abs(last - i) == k;
    }

    public void solve(int n, int k, List<Integer> list, int num, int idx) {
        if (idx == n) {
            int len=((int) Math.log10(num) + 1);
            if (len == n) {
                list.add(num);
            }

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (isValid(num, i, k)) {
                num=(num*10)+i;
                solve(n, k, list, num, idx + 1);//Permutation
                num/=10;
            }
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        solve(n, k, list, 0, 0);

        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }
}

```
