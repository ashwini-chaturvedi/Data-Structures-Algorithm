# Problem: Two Alarms

You have two alarms. The first one rings at times \(X, 2X, 3X, \ldots\), and the second one rings at times \(Y, 2Y, 3Y, \ldots\).

You have a tolerance of \(D\). You will wake up at the **earliest** time \(t > 0\) such that:

- At least one alarm rings at time \(t\), and
- The **other** alarm also rang at some time \(s > 0\), where \(s \le t\) and \(t - s \le D\).

That is, you will wake up at the first instant of time that both alarms ring within \(D\) seconds of each other.

Both alarms may ring at the same time.

Find the time at which you wake up. It can be proved that you will always wake up within a finite amount of time.

## Input Format

- The first line of input contains a single integer \(T\), denoting the number of test cases.
- Each test case consists of a single line containing three space-separated integers \(X\), \(Y\), and \(D\) — the periods of the two alarms and your tolerance.

## Output Format

For each test case, output on a new line the time at which you wake up.

## Constraints

- \(1 \le T \le 10^5\)
- \(1 \le X, Y \le 10^6\)
- \(0 \le D < \min(X, Y)\)
- The sum of \(X\) over all test cases does not exceed \(10^6\).
- The sum of \(Y\) over all test cases does not exceed \(10^6\).

## Sample 1

### Input

    5
    3 5 0
    2 3 1
    6 8 2
    9 9 0
    987799 975780 200

### Output

    15
    3
    8
    9
    4731557220


------
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

        long x = nextLong();
        long y = nextLong();
        long d = nextLong();
        
        long ans=findMinTime(x,y,d);
        sb.append(ans).append("\n");

    }
    
    static long findMinTime(long x,long y,long d){
       long newX=x;
       long newY=y;
       
       long lastX=0;
       long lastY=0;
       
       long mulX=1;
       long mulY=1;
       
       while(true){
           if(newX==newY)return newX;
           
           if(newX<newY){
               if(lastY!=0 && newX-lastY<=d){
                   return newX;
               }
               
               lastX=newX;
               mulX++;
               newX=mulX*x;
           }else{
                if(lastX!=0 && newY-lastX<=d){
                   return newY;
               }
               
               lastY=newY;
               mulY++;
               newY=mulY*y;
           }
       }
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
