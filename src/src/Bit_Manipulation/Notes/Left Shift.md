# Left Shift(<<):Shifts the Set bit to the Left

---                         

# Formula: (n<<k=n*(2^k) )

---

## How it works:
### Arithmetic Left Shift (<<):

  - The leftmost bits are discarded.
  - The empty positions on the right are filled with 0.

```java
public class LeftShiftExample {
    public static void main(String[] args) {
        int num = 5; // Binary: 00000101
        int shifted = num << 2; // Shift 2 positions to the left
        System.out.println("Result of 5 << 2: " + shifted); // Output: 20(00010100)

        // For negative numbers
        int negNum = -5; // Binary (2's complement): 11111011
        int shiftedNeg = negNum << 2; // Shift 2 positions to the left
        System.out.println("Result of -5 << 2: " + shiftedNeg);11101100
    }
}
```
