# Monotonic Stack Cheat Sheet (NGE, NSE, PGE, PSE)

## Step 1: Recognize the Pattern

If the problem contains phrases like:

- Nearest Greater
- Nearest Smaller
- First Greater on Left/Right
- First Smaller on Left/Right
- Span
- Visible Buildings
- Histogram
- Subarray Minimum/Maximum
- Next Warmer Day
- Maximum Range

Think:

```text
MONOTONIC STACK
```

---

# Core Idea

Ask yourself:

> Which element can stop/block the current element?

The answer determines whether you need:

- Greater Element
- Smaller Element

and whether you need it:

- On the Left
- On the Right

---

# Decision Table

| Need | Direction | Pop Condition |
|--------|----------|---------------|
| NGE (Next Greater Element) | Right → Left | <= |
| NSE (Next Smaller Element) | Right → Left | >= |
| PGE (Previous Greater Element) | Left → Right | <= |
| PSE (Previous Smaller Element) | Left → Right | >= |

---

# How To Decide?

## Need First Greater On Right

Example:

```text
73 74 75 71 69 72 76
```

Question:

> When will I get a warmer temperature?

Need:

```text
NGE
```

---

## Need First Smaller On Right

Example:

```text
4 8 5 2
```

Question:

> What's the first smaller element on the right?

Need:

```text
NSE
```

---

## Need First Greater On Left

Example:

```text
100 80 60 70 60 75 85
```

Question:

> What is the nearest previous greater value?

Need:

```text
PGE
```

---

## Need First Smaller On Left

Example:

```text
2 7 4 3
```

Question:

> What is the nearest previous smaller value?

Need:

```text
PSE
```

---

# Universal Templates

## Next Greater Element (NGE)

```java
for(int i=n-1;i>=0;i--){

    while(!st.isEmpty() && st.peek() <= arr[i]){
        st.pop();
    }

    ans[i] = st.isEmpty() ? -1 : st.peek();

    st.push(arr[i]);
}
```

---

## Next Smaller Element (NSE)

```java
for(int i=n-1;i>=0;i--){

    while(!st.isEmpty() && st.peek() >= arr[i]){
        st.pop();
    }

    ans[i] = st.isEmpty() ? -1 : st.peek();

    st.push(arr[i]);
}
```

---

## Previous Greater Element (PGE)

```java
for(int i=0;i<n;i++){

    while(!st.isEmpty() && st.peek() <= arr[i]){
        st.pop();
    }

    ans[i] = st.isEmpty() ? -1 : st.peek();

    st.push(arr[i]);
}
```

---

## Previous Smaller Element (PSE)

```java
for(int i=0;i<n;i++){

    while(!st.isEmpty() && st.peek() >= arr[i]){
        st.pop();
    }

    ans[i] = st.isEmpty() ? -1 : st.peek();

    st.push(arr[i]);
}
```

---

# Value Stack vs Index Stack

## Store Values

Used when:

```text
Need actual greater/smaller value
```

Example:

```java
Stack<Integer> st;
```

---

## Store Indices

Used when:

```text
Need distance
Need width
Need boundaries
Need contribution calculation
```

Example:

```java
Stack<Integer> st;

while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
    st.pop();
}
```

---

# Advanced Pattern Recognition

## Pattern 1

Question:

> How far can I expand?

or

> What's the maximum range?

Think:

```text
Find nearest element that blocks expansion.
```

---

## Pattern 2

Question:

> Current element remains valid until a SMALLER element appears.

Need:

```text
PSE + NSE
```

Examples:

- Largest Rectangle Histogram
- Sum of Subarray Minimums

---

## Pattern 3

Question:

> Current element remains valid until a GREATER element appears.

Need:

```text
PGE + NGE
```

Examples:

- Sum of Subarray Maximums
- Maximum contribution problems

---

# Largest Rectangle in Histogram

## Interview Thought Process

Don't memorize:

```text
Histogram → NSE + PSE
```

Think:

For every bar:

```text
How far left can it expand?
Until a smaller bar appears.

How far right can it expand?
Until a smaller bar appears.
```

Therefore:

```text
Need Previous Smaller
Need Next Smaller
```

---

## Formula

```text
Width = NSE[i] - PSE[i] - 1
Area = Height[i] * Width
```

---

# Sum of Subarray Minimums

For every element:

```text
How many subarrays use me as the minimum?
```

Need:

```text
PSE
NSE
```

Contribution:

```text
arr[i] * leftChoices * rightChoices
```

where

```text
leftChoices = i - PSE[i]
rightChoices = NSE[i] - i
```

---

# Sum of Subarray Maximums

Need:

```text
PGE
NGE
```

Contribution:

```text
arr[i] * leftChoices * rightChoices
```

---

# Stock Span

Question:

```text
How many consecutive elements before me are smaller?
```

Need:

```text
Previous Greater Element
```

Formula:

```text
span = currentIndex - PGEIndex
```

---

# Daily Temperatures

Question:

```text
When is the next warmer day?
```

Need:

```text
NGE
```

Store:

```text
Indices
```

Answer:

```text
nextGreaterIndex - currentIndex
```

---

# Circular Array Problems

Examples:

- Next Greater Element II

Common trick:

```java
for(int i=2*n-1;i>=0;i--){
    int curr = arr[i % n];
}
```

Traverse twice.

---

# One-Line Identification Trick

Ask:

```text
What element stops/blocks the current element?
```

If answer is:

```text
Greater element
```

Use:

```text
NGE or PGE
```

If answer is:

```text
Smaller element
```

Use:

```text
NSE or PSE
```

Then ask:

```text
Is it on the left or right?
```

and choose accordingly.

---

# Final Cheat Table

| Problem Type | Use |
|--------------|-----|
| Next Warmer Day | NGE |
| First Smaller Right | NSE |
| Stock Span | PGE |
| Previous Smaller | PSE |
| Histogram | PSE + NSE |
| Subarray Minimums | PSE + NSE |
| Subarray Maximums | PGE + NGE |
| Range Until Smaller Appears | PSE + NSE |
| Range Until Greater Appears | PGE + NGE |
| Circular Next Greater | NGE + Double Traversal |

---

# Golden Rule

Whenever you hear:

```text
Nearest
First
Next
Previous
Greater
Smaller
Span
Boundary
Range
Expansion
```

Your first thought should be:

```text
MONOTONIC STACK
```
