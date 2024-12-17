```java
import java.util.PriorityQueue;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Step 1: Count the frequency of each character
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Use a max heap to store characters based on their lexicographical order
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.add((char) (i + 'a'));
            }
        }

        StringBuilder result = new StringBuilder();

        // Step 3: Construct the string based on repeat limit
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            int useCount = Math.min(freq[current - 'a'], repeatLimit); // Use up to `repeatLimit` times
            
            // Append the character `useCount` times
            for (int i = 0; i < useCount; i++) {
                result.append(current);
            }

            freq[current - 'a'] -= useCount; // Reduce the frequency of the current character

            if (freq[current - 'a'] > 0) { 
                // If there are more occurrences of this character, but we reached the limit
                if (maxHeap.isEmpty()) break; // If no other character is available, we are done

                // Get the next character (lexicographically smaller)
                char next = maxHeap.poll();
                result.append(next); // Add this alternate character once
                freq[next - 'a']--;

                // Put both characters back into the heap if they still have remaining occurrences
                if (freq[next - 'a'] > 0) maxHeap.add(next);
                maxHeap.add(current);
            }
        }

        return result.toString();
    }
}
```
