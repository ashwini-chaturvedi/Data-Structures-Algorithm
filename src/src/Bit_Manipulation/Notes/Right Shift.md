# Right Shift:Shifts the Set bit to the Right

---                         

# Formula: (n>>k=n/(2^k) )

---

# How it works:
## Arithmetic Right Shift (>>):

- It preserves the sign bit (most significant bit).

- For positive numbers, it fills with 0 from the left.

- For negative numbers, it fills with 1 from the left (to maintain the sign).

## Logical Right Shift (>>>) (specific to languages like Java):

- It does not preserve the sign bit.
- Always fills with 0 from the left, irrespective of the sign of the number.

