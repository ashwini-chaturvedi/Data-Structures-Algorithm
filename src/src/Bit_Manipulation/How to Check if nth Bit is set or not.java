1. Right Shift(>>) the number by n positions. // int mask=number>>n
2. Take its Logical AND with 1.// boolean isSet=(mask & 1);
   Right Shift n times and then Take Logical AND of that with 1.

   .if it is 1 that means nth bit was set
   .else it isn't so break the loop.

  e.g.
  public class Main {
    public static void main(String[] args) {
        int number = 5;  // binary: 0101
        int n = 2;       // check if the 2nd bit is set
        
        if (((number >> n) & 1) == 1) {
            System.out.println("The " + n + "-th bit is set.");
        } else {
            System.out.println("The " + n + "-th bit is not set.");
        }
    }
}
