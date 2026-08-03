# Special Power Function for Handling int overflow.
```java
public long power(long base, long exp) {
        long result = 1;
    
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= base;
            } 
            base *= base;
            exp >>= 1;
        }
    
        return result;
    }
```
