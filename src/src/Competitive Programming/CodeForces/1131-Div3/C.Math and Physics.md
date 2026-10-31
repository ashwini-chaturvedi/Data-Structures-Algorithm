There are n nuclear cores arranged in a line, numbered from 1 to n from left to right. The i-th core has an initial mass of ai.

In one operation, you can choose a core i (1≤i≤k, where k is the current number of cores) such that its mass ai≥2. You then split it into two positive integer parts x and y such that x≥1, y≥1, and x+y=ai.

After splitting, the i-th core is removed from the sequence, decreasing the total number of cores by 1. The mass x is added to the left neighbor of the removed core, if it exists. The mass y is added to the right neighbor of the removed core, if it exists. If a neighbor does not exist, the corresponding mass is lost to the environment.

The sequence immediately shifts to close the gap. The process stops when no further operations can be performed.

Determine whether it is possible to end the process with exactly one core remaining. If it is possible, find the maximum possible mass of this single final core.

Input:

The first line of the input contains a single integer t (1≤t≤10^4) — the number of test cases. The description of each test case follows.

The first line of each test case contains a single integer n (2≤n≤2*10^5) — the initial number of nuclear cores.

The second line of each test case contains n integers a1,a2,…,an (1≤ai≤1000) — the initial masses of the cores.

It is guaranteed that the sum of n over all test cases does not exceed 2*10^5.

Output:

For each test case, print a single integer — the maximum possible mass of the final remaining core. If it is impossible to end up with exactly one core, print −1 instead.

Example:

Input:

t=3
{
(4,[1 2 3 4]),
(5,[1 1 1 1 1]),
(2,[6 7])
}

Output:

[9,-1,12]

Note
Consider the first test case. The initial sequence is [1,2,3,4]. An optimal sequence of operations is:

Split the 2 into x=1, y=1: the sequence becomes [1+1,3+1,4]=[2,4,4].

Split the first 4 into x=1, y=3: the sequence becomes [2+1,4+3]=[3,7].

Split the 3 into x=1,y=2. The 1 is permanently lost to the left, and the 2 is added to the right core. The final sequence is [7+2]=[9].

Now, exactly one core is left, and it has a mass of 9. It can be shown that this is the maximum possible.

For the second test case, no operation can be performed, and thus, it is impossible to end up with a single core remaining. Hence, output −1.

# Approach:

i. If every core is 1 nothing can be split so the answer is -1
ii. 

# Optimizing:
# C. Math and Physics: Approach and Bug Explanation

## Problem summary

- There are `n` cores in a line with masses `a[1..n]`.
- One operation picks a core with mass `>= 2` and splits it into `x, y >= 1` with `x + y = mass`.
- `x` goes to the left neighbour and `y` to the right neighbour.
- If a neighbour doesn't exist, that part is **lost**.
- Goal: end with exactly one core and maximize its mass, or print `-1` if impossible.

---

## 1. What the original code did

```java
if (allOne) print -1
else        print sum - 1
```

- If every core is `1`, nothing can be split, so the answer is `-1`. **Correct.**
- Otherwise it assumed the only unavoidable loss is `1`, giving `sum - 1`. **Wrong in some cases.**

---

## 2. Key observations

### Where is mass lost?

Mass is lost **only** when splitting a core at the left end or right end of the line.

| Split location | Loss |
|---|---|
| Middle core (both neighbours exist) | 0 |
| End core (one neighbour missing) | at least 1 (since `x, y >= 1`) |

### How many operations are needed?

Each operation reduces the core count by 1. Going from `n` cores to `1` core needs exactly **`n - 1` operations**.

So the real question is: how many of those operations are forced to be end splits?

---

## 3. Why `sum - 1` fails

Counterexample: `a = [2, 1, 1, 1]`, `sum = 5`. The old code prints `4`.

- Only the first core is `>= 2`, so only it can be split, and it is an end core.
- Split `2` into `(1, 1)`: the left `1` is lost, the right `1` goes to the next core. The line becomes `[2, 1, 1]`.
- Again: `[2, 1]`. Again: `[2]`.

That is 3 operations, each losing 1, so the answer is `5 - 3 = 2`.

The middle `1`s can never be split. Whenever an end core splits, its neighbour grows but also becomes the new end. So every operation is forced to happen at an end, and each one loses at least 1.

---

## 4. The three cases

| Situation | Answer |
|---|---|
| All cores are `1` | `-1` |
| Some **interior** core (positions `2..n-1`) has mass `>= 2` | `sum - 1` |
| Only end cores are `>= 2`, all interior cores are `1` | `sum - (n - 1)` |

### Case A: all ones

No operation is possible, so the answer is `-1`.

### Case B: some interior core is `>= 2`

- Splitting an interior core loses nothing.
- Both neighbours grow by at least 1, so they become splittable too.
- You can keep splitting through the interior with zero loss.
- Only the very last operation, on one of the final two end cores, loses exactly 1.

Answer: `sum - 1`.

### Case C: interior is all `1`, an end core is `>= 2`

- Interior `1`s are never splittable, so every operation is an end split.
- There are `n - 1` operations, each losing at least 1, so the answer is at most `sum - (n - 1)`.
- This is achievable: always split an end core `m` as `(1, m - 1)`. It loses exactly 1 and passes the rest to its neighbour.

Answer: `sum - (n - 1)`.

For `n = 2` there is no interior, and `sum - (n - 1) = sum - 1`, so the formula is consistent.

---

## 5. The code change

A new flag `interiorBig` detects whether any core at 0-indexed positions `1..n-2` has mass `>= 2`:

```java
if (num > 1) {
    allOne = false;
    if (i > 0 && i < n - 1) interiorBig = true;   // NEW
}
```

The decision now has three branches instead of two:

```java
if (allOne)           -1
else if (interiorBig) sum - 1
else                  sum - (n - 1)               // NEW
```

Everything else (fast input, `long sum`, the `allOne` check) was already fine.

---

## 6. Final corrected solution

```java
static void solve() throws IOException {
    int n = nextInt();
    long sum = 0;
    boolean allOne = true, interiorBig = false;

    for (int i = 0; i < n; i++) {
        int num = nextInt();
        if (num > 1) {
            allOne = false;
            if (i > 0 && i < n - 1) interiorBig = true;
        }
        sum += num;
    }

    if (allOne) sb.append(-1).append("\n");
    else if (interiorBig) sb.append(sum - 1).append("\n");
    else sb.append(sum - (n - 1)).append("\n");
}
```

---

## 7. Verification on the samples

| Input | Reasoning | Output |
|---|---|---|
| `[1, 2, 3, 4]` | interior has `2, 3`, so `10 - 1` | `9` |
| `[1, 1, 1, 1, 1]` | all ones | `-1` |
| `[6, 7]` | `n = 2`, so `13 - 1` | `12` |

Extra check: `[2, 1, 1, 1]` gives `5 - 3 = 2`.

---

## Complexity

- Time: `O(n)` per test case.
- Space: `O(1)` extra.

```java


import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();

            if (line == null) {
                throw new EOFException();
            }

            st = new StringTokenizer(line);
        }

        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static void solve() throws IOException {
        int n = nextInt();
        long sum = 0;
        boolean allOne = true, interiorBig = false;

        for (int i = 0; i < n; i++) {
            int num = nextInt();
            if (num > 1) {
                allOne = false;
                if (i > 0 && i < n - 1) interiorBig = true;
            }
            sum += num;
        }

        if (allOne) sb.append(-1).append("\n");
        else if (interiorBig) sb.append(sum - 1).append("\n");
        else sb.append(sum - (n - 1)).append("\n");
    }

    public static void main(String[] args) throws Exception {

        int t = nextInt();

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {
            solve();
        }

        System.out.println(sb);
    }


}
```
