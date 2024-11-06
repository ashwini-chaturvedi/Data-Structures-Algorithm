# Method 1: Using Integer.bitCount()
  ## Java has a built-in method Integer.bitCount(int n) that returns the number of set bits in an integer.

```java

int number = 29; // Example number
int setBits = Integer.bitCount(number);
System.out.println("Number of set bits: " + setBits);
```
# Method 2: Using Bitwise Operations
  ## You can count set bits manually using bitwise operations by repeatedly checking if the least significant bit is set and then shifting the number right.

```java

int number = 29; // Example number
int count = 0;

while (number > 0) {
    count += (number & 1); // Check if the last bit is 1
    number >>= 1;          // Shift right by 1 to check the next bit
}

System.out.println("Number of set bits: " + count);
```
# Method 3: Using a Custom Method with n & (n - 1)
  ## This approach removes the lowest set bit in each iteration, which is efficient as it loops only for the number of set bits.

```java

int number = 29; // Example number
int count = 0;

while (number > 0) {
    number &= (number - 1); // Removes the lowest set bit
    count++;
}

System.out.println("Number of set bits: " + count);
```
