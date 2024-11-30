# Right Shift:Shifts the Set bit to the Right

---                         

# Formula: (n>>k=n/(2^k) )

---

## How it works:
### Arithmetic Right Shift (>>):

- It preserves the sign bit (most significant bit).

- For positive numbers, it fills with 0 from the left.

- For negative numbers, it fills with 1 from the left (to maintain the sign).

 ```java
public class RightShiftExample {
    public static void main(String[] args) {
        int num = 16; // Binary: 00010000
        int shifted = num >> 2; // Shift 2 positions to the right
        System.out.println("Result of 16 >> 2: " + shifted); // Output: 4

        // For negative numbers
        int negNum = -16; // Binary (2's complement): 11110000
        int shiftedNeg = negNum >> 2; // Shift 2 positions to the right
        System.out.println("Result of -16 >> 2: " + shiftedNeg); // Output: -4
    }
}

 ```

### Logical Right Shift (>>>) (specific to languages like Java):

- It does not preserve the sign bit.
- Always fills with 0 from the left, irrespective of the sign of the number.


