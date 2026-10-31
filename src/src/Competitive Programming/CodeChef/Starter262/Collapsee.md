![](https://www.codechef.com/START262D/problems/COLLAPSEE)

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) throw new IOException("Unexpected end of input");
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
        
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=nextInt();
        }
        
        long sum=0;
        for(int i=0;i<n-2;i++){
            sum+=Math.abs(nums[i]);
        }
        
        sum-=nums[n-2];
        sum+=nums[n-1];
        
        output.append(sum).append('\n');
    }

    public static void main(String[] args) throws Exception {
        int t = nextInt();
        while (t-- > 0) {
            solve();
        }
        System.out.print(output);
    }
}

```
