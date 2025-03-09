# Trick
When there is Circular Array in the Question

1.Append the array 2nd time into the existing array means 1st array me 2nd time append krdo taaki rotation na krna pde circular array types*/

# 1. Forward Traversal (Clockwise)
```text
In forward traversal, we move from a starting index start and proceed clockwise, wrapping around the array
if necessary.
```
```java
public void forwardTraversal(int[] arr, int start, int steps) {
    int n = arr.length;
    System.out.print("Forward Traversal: ");
    for (int i = 0; i < steps; i++) {
        int idx = (start + i) % n;
        System.out.print(arr[idx] + " ");
    }
    System.out.println();
}
```
# 2. Backward Traversal (Counterclockwise)
```text
In backward traversal, we move from a starting index start and proceed counterclockwise, wrapping around 
the array if necessary.
```
```java
public void backwardTraversal(int[] arr, int start, int steps) {
    int n = arr.length;
    System.out.print("Backward Traversal: ");
    for (int i = 0; i < steps; i++) {
        int idx = (start - i + n) % n; // Add n to avoid negative indices
        System.out.print(arr[idx] + " ");
    }
    System.out.println();
}
```
# 3. Full Traversal
```text
Full traversal means visiting every element of the circular array exactly once, starting at a given index 
and wrapping around.
```
```java
public void fullTraversal(int[] arr, int start) {
    int n = arr.length;
    System.out.print("Full Traversal: ");
    for (int i = 0; i < n; i++) {
        int idx = (start + i) % n;
        System.out.print(arr[idx] + " ");
    }
    System.out.println();
}
```

# 4. Custom Range Traversal
```text
Custom range traversal allows summing or visiting a certain number of elements either forward or backward,
 depending on a given k value.
```
```java
public void customRangeTraversal(int[] arr, int start, int k) {
    int n = arr.length;
    System.out.print("Custom Range Traversal: ");
    if (k > 0) {
        for (int i = 1; i <= k; i++) {
            int idx = (start + i) % n;
            System.out.print(arr[idx] + " ");
        }
    } else if (k < 0) {
        for (int i = 1; i <= -k; i++) {
            int idx = (start - i + n) % n; // Add n to handle negative indices
            System.out.print(arr[idx] + " ");
        }
    }
    System.out.println();
}
```

# 5. Bidirectional Traversal
```text
This type alternates between forward and backward steps for a specified range.
```
```java
public void bidirectionalTraversal(int[] arr, int start, int steps) {
    int n = arr.length;
    System.out.print("Bidirectional Traversal: ");
    for (int i = 0; i < steps; i++) {
        int idx = (i % 2 == 0) ? (start + i) % n : (start - i + n) % n;
        System.out.print(arr[idx] + " ");
    }
    System.out.println();
}
```

# Full Test Example:
```java
Combine all methods in a single program for testing:

public static void main(String[] args) {
    int[] arr = {5, 7, 1, 4};

    forwardTraversal(arr, 1, 6);
    backwardTraversal(arr, 2, 5);
    fullTraversal(arr, 3);
    customRangeTraversal(arr, 1, 3);
    customRangeTraversal(arr, 1, -2);
    bidirectionalTraversal(arr, 2, 6);
}
```
