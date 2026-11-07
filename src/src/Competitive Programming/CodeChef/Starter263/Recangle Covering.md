# Problem: Rectangle Covering

You are given a binary grid with \(N\) rows and \(M\) columns. The grid contains at least one cell equal to \(1\).

The cell at the intersection of the \(i\)-th row and \(j\)-th column is denoted \((i,j)\).

A **rectangular sub-grid** is a rectangular region of the grid.

Formally, it is defined by two cells \((x_1,y_1)\) and \((x_2,y_2)\) such that \(x_1 \le x_2\) and \(y_1 \le y_2\), and contains all cells \((i,j)\) such that:

- \(x_1 \le i \le x_2\), and
- \(y_1 \le j \le y_2\).

The area of a rectangular sub-grid is defined to be the number of cells it contains.

Find the **minimum area** of a rectangular sub-grid such that the following condition holds:

- Every cell **not contained** in the sub-grid has the value `0`.

## Input Format

- The first line of input contains a single integer \(T\), denoting the number of test cases.
- Each test case consists of multiple lines of input:
  - The first line of each test case contains two space-separated integers \(N\) and \(M\) — the number of rows and columns of the grid.
  - The next \(N\) lines describe the grid. The \(i\)-th of these lines contains a binary string of length \(M\) — the \(i\)-th row of the grid.

## Output Format

For each test case, output on a new line the smallest possible area.

## Constraints

- \(1 \le T \le 50\)
- \(1 \le N, M \le 30\)
- Each grid contains at least one `1`.
- There is no bound on the sum of \(N \cdot M\) over all test cases.

## Sample 1

### Input

    4
    1 1
    1
    3 4
    0000
    0110
    0010
    4 5
    10000
    00000
    00000
    00001
    3 6
    000000
    000110
    000000

### Output

    1
    4
    20
    2

## Explanation

**Test case 2:** The `1`s occupy rows 2 to 3 and columns 2 to 3, so the smallest rectangle has area \(2 \cdot 2 = 4\).

**Test case 3:** Two opposite corner cells are `1`, so all \(4 \cdot 5 = 20\) cells must lie in the rectangle.


```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
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
        int m = nextInt();
        
        int minR=Integer.MAX_VALUE;
        int maxR=Integer.MIN_VALUE;
        int minC=Integer.MAX_VALUE;
        int maxC=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            String s=next();
            for(int j=0;j<m;j++){
                char ch=s.charAt(j);
                if(ch=='1'){
                    minR=Math.min(minR,i);
                    maxR=Math.max(maxR,i);
                    
                    minC=Math.min(minC,j);
                    maxC=Math.max(maxC,j);
                }
            }
        }
        

        int h=(maxR-minR+1);
        int w=(maxC-minC+1);
        
        int ans=h*w;
        
        sb.append(ans).append("\n");
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
