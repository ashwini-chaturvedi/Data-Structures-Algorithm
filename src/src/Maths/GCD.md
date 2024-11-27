# Recursive
```java
    public static int gcd(int a, int b) {
        if (b == 0) return a; // Base case: when b becomes 0, a is the GCD
        return gcd(b, a % b); // Recursive step: gcd(b, a % b)
    }
```
# Iterative
```java
public static int gcd(int a, int b) {
  while (b != 0) {
     int temp = b;
     b = a % b;
     a = temp;
  }
    return a;
}
```
