# Array Optimization Techniques

## Whenever thinking of optimizing Problems of Array Mainly 4 patterns are main:

---

# 1. Two Pointers Technique

**Repository:**  
https://github.com/ashwini-chaturvedi/Data-Structures-Algorithm/tree/main/src/src/Two%20Pointers

### Definition

**Used When we want Exactly 2 Points/Indices and Nothing else in between.**

### When to Use

Use Two Pointers when:

- You need exactly two indices/pointers.
- The array is sorted.
- You need to find pairs or triplets.
- You need to compare elements from both ends.
- Elements between the pointers are not important.

### Recognition Keywords

- Pair Sum
- Triplet Sum
- Sorted Array
- Closest Pair
- Remove Duplicates
- Palindrome
- Merge Sorted Arrays

### Common Problems

- Two Sum II
- 3Sum
- 4Sum
- Container With Most Water
- Valid Palindrome
- Remove Duplicates From Sorted Array

### General Template

```java
int left = 0;
int right = n - 1;

while(left < right){

    if(condition){
        return answer;
    }
    else if(needsLargerValue){
        left++;
    }
    else{
        right--;
    }
}
```

### Time Complexity

| Approach | Complexity |
|-----------|-----------|
| Brute Force | O(n²) |
| Two Pointers | O(n) |

---

# 2. Sliding Window

**Repository:**  
https://github.com/ashwini-chaturvedi/Data-Structures-Algorithm/tree/main/src/src/SlidingWindow

### Definition

**No Negative Number is Present and want continuous Subarray etc.**

### When to Use

Use Sliding Window when:

- A continuous Subarray or Substring is involved.
- You need Longest or Shortest window.
- You need Maximum or Minimum length.
- The window can expand and shrink dynamically.
- The array contains non-negative numbers (classic sliding window).

### Recognition Keywords

- Longest Substring
- Shortest Subarray
- Maximum Length
- Minimum Length
- At Most K
- Exactly K
- Continuous Segment
- Window

### Important Note

Classic Sliding Window generally works when:

```text
No Negative Numbers are Present
```

If negative numbers are involved, the window sum may become unpredictable and Prefix Sum techniques are often required instead.

### Common Problems

- Longest Substring Without Repeating Characters
- Minimum Window Substring
- Max Consecutive Ones III
- Fruits Into Baskets
- Subarrays With K Different Integers

### General Template

```java
int left = 0;

for(int right = 0; right < n; right++){

    // include right element

    while(windowIsInvalid){

        // remove left element
        left++;
    }

    answer = updateAnswer();
}
```

### Time Complexity

| Approach | Complexity |
|-----------|-----------|
| Brute Force | O(n²) |
| Sliding Window | O(n) |

---

# 3. Prefix Sum

**Repository:**  
https://github.com/ashwini-chaturvedi/Data-Structures-Algorithm/tree/main/src/src/Prefix%20Sum

### Definition

**Prefix sum is Use to Solve problems involving sum of Elements b/w two indices in an array or Subarray.**

### Core Formula

```java
Sum(l,r)=prefixSum(r)-prefixSum(l-1)
```

### When to Use

Use Prefix Sum when:

- Sum of elements between two indices is required.
- Range Sum Queries are involved.
- Count of Subarrays is required.
- Sum of Subarray equals K.
- Sum divisible by K.
- Longest Subarray with a given sum.

### Recognition Keywords

- Range Sum
- Subarray Sum
- Count Subarrays
- Sum Equals K
- Divisible By K
- Continuous Segment Sum
- Query [L, R]

### Common Problems

- Range Sum Query
- Subarray Sum Equals K
- Continuous Subarray Sum
- Count Subarrays Divisible By K
- Contiguous Array

### Prefix Sum + HashMap Pattern

Frequently used in:

```text
Count Subarrays
Longest Subarray
Subarray Sum = K
```

```java
Map<Integer,Integer> map = new HashMap<>();
map.put(0,1);

int prefix = 0;

for(int num : nums){

    prefix += num;

    if(map.containsKey(prefix - k)){
        // found valid subarray
    }

    map.put(prefix,
            map.getOrDefault(prefix,0)+1);
}
```

### Time Complexity

| Approach | Complexity |
|-----------|-----------|
| Brute Force | O(n²) |
| Prefix Sum | O(n) |

---

# 4. Kadane's Algorithm

**Repository:**  
https://github.com/ashwini-chaturvedi/Data-Structures-Algorithm/tree/main/src/src/Dynamic-Programming/Patterns/Kadane's%20Algorithm

### Definition

**It works on Negative Number but to find MAXIMUM sum not to find the Count.**

### When to Use

Use Kadane's Algorithm when:

- Maximum Sum Subarray is required.
- Maximum Profit Segment is required.
- Largest Continuous Sum is required.
- Negative numbers are present.
- Optimization of contiguous sums is needed.

### Recognition Keywords

- Maximum Sum Subarray
- Largest Sum Contiguous Segment
- Best Profit
- Maximum Score Segment
- Maximum Continuous Sum

### Important Note

Kadane's Algorithm:

✅ Works with Negative Numbers

✅ Finds Maximum Sum

❌ Does NOT count subarrays

❌ Does NOT answer range sum queries

### Core Idea

At every index:

- Start a new subarray from the current element.
- Extend the previous subarray.

```java
current = Math.max(nums[i],
                   current + nums[i]);
```

### General Template

```java
int current = nums[0];
int answer = nums[0];

for(int i = 1; i < nums.length; i++){

    current = Math.max(nums[i],
                       current + nums[i]);

    answer = Math.max(answer,
                      current);
}
```

### Common Problems

- Maximum Subarray
- Maximum Circular Subarray
- Maximum Product Subarray (Variation)
- Best Time To Buy And Sell Stock (Variation)

### Time Complexity

| Approach | Complexity |
|-----------|-----------|
| Brute Force | O(n²) |
| Kadane | O(n) |

---

# Quick Pattern Identification Cheat Sheet

| Question Pattern | Technique |
|-----------------|-----------|
| Pair / Triplet in Sorted Array | Two Pointers |
| Longest / Shortest Substring | Sliding Window |
| Continuous Window with At Most K | Sliding Window |
| Range Sum Query | Prefix Sum |
| Count Subarrays | Prefix Sum |
| Subarray Sum = K | Prefix Sum + HashMap |
| Sum Divisible By K | Prefix Sum + HashMap |
| Maximum Sum Contiguous Subarray | Kadane |
| Largest Continuous Profit/Sum | Kadane |

---

# Interview Recognition Flow

### Pair / Triplet ?

→ Two Pointers

### Longest or Shortest Subarray / Substring ?

→ Sliding Window

### Count Subarrays ?

→ Prefix Sum

### Sum Between Indices ?

→ Prefix Sum

### Subarray Sum = K ?

→ Prefix Sum + HashMap

### Maximum Sum Contiguous Segment ?

→ Kadane

---

# Golden Rule

- **Pair / Triplet** → Think Two Pointers
- **Longest / Shortest Window** → Think Sliding Window
- **Count / Sum of Subarrays** → Think Prefix Sum
- **Maximum Continuous Sum** → Think Kadane

These four patterns alone solve a huge percentage of Array and String interview problems efficiently.
