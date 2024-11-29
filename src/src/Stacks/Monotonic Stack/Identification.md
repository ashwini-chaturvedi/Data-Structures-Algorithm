```java
# Identifying Monotonic Stack Problems

Monotonic stack problems typically involve array or sequence processing tasks where you need to find relationships between elements, such as the **next greater element**, **next smaller element**, or spans of elements satisfying a condition.

---

## 1. Problem Characteristics

1. **Subsequent Relationship Queries**:
   - Find relationships like:
     - The **next greater element**.
     - The **next smaller element**.
     - The **previous greater element**.
     - The **previous smaller element**.

2. **Span or Range Queries**:
   - Questions involving spans, e.g.:
     - Stock span (how many previous days have stock prices ≤ current day).
     - Maximum area in a histogram.

3. **Optimization with Local Comparisons**:
   - Tasks that involve comparisons between consecutive or nearby elements.

4. **Brute Force is Too Slow**:
   - Problems where a nested loop \(O(n^2)\) solution is too slow, but a monotonic stack reduces complexity to \(O(n)\).

5. **Sliding Window-Like Patterns**:
   - Tracking a window of values in sorted order.

---

## 2. Key Indicators in the Problem Statement

Look for phrases like:
- **"Next greater"** or **"Next smaller"**.
- **"Previous greater"** or **"Previous smaller"**.
- **"First element to the left/right"** or **"Nearest element to the left/right"**.
- **"Span of elements"** or **"Range of valid indices"**.
- **"Area of rectangles"** or **"Largest rectangle in a histogram"**.

---

## 3. Example Problems

| **Problem**                          | **Description**                                               |
|--------------------------------------|---------------------------------------------------------------|
| **Next Greater Element (NGE)**       | Find the next greater element for each element in an array.   |
| **Largest Rectangle in Histogram**   | Find the largest rectangle's area in a histogram.            |
| **Daily Temperatures**               | Find how many days until a warmer temperature.               |
| **Stock Span Problem**               | Find the span of stock prices for consecutive days.          |
| **Trapping Rain Water**              | Compute water trapped between bars of different heights.      |

---

## 4. Monotonic Stack Overview

A **monotonic stack** ensures that elements are stored in a specific order:
- **Increasing Monotonic Stack**:
  - Maintains elements in ascending order.
  - Used for **next smaller** or **previous smaller** problems.
- **Decreasing Monotonic Stack**:
  - Maintains elements in descending order.
  - Used for **next greater** or **previous greater** problems.

---

## 5. Implementation Steps

1. **Traverse the Array**:
   - Either left-to-right or right-to-left depending on the problem.
2. **Maintain Monotonicity**:
   - Use a stack to keep elements in increasing or decreasing order.
3. **Process Each Element**:
   - While the stack's top violates monotonicity, pop the stack.
   - The stack's top (or empty state) provides the desired relationship.
   - Push the current element (or its index) onto the stack.

---

## 6. Common Patterns

| **Type**                  | **Direction**  | **Stack Order**       |
|---------------------------|----------------|-----------------------|
| **Next Greater Element**  | Right          | Decreasing            |
| **Previous Greater**      | Left           | Decreasing            |
| **Next Smaller Element**  | Right          | Increasing            |
| **Previous Smaller**      | Left           | Increasing            |

---

## 7. Example Walkthrough

### Problem: **Next Greater Element**
**Input**: `[4, 5, 2, 25]`  
**Output**: `[5, 25, 25, -1]`  

---

### Approach Using Monotonic Stack

1. Traverse from right to left (since we are finding "next greater").
2. Maintain a **decreasing stack** (store elements in descending order).
3. For each element:
   - While the stack is not empty and the top of the stack is **less than or equal** to the current element, pop the stack.
   - If the stack becomes empty, there is no greater element; otherwise, the top of the stack is the next greater element.
   - Push the current element onto the stack.

---

### Implementation

```java
public int[] nextGreaterElement(int[] nums) {
    int[] result = new int[nums.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = nums.length - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }

    return result;
}

```
