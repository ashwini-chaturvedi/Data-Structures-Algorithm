# Brute-Force
```java
class Solution {

    // ch=(char)('a'+(ch-'a'+shiftPosition))%26); this will shift the ch to shiftPosition times front or Back

    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb = new StringBuilder(s);

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 0 ? -1 : 1;

            for (int i = start; i <= end; i++) {
                char ch = sb.charAt(i);

                // Correctly shift with wrapping
                ch = (char) ('a' + ((ch - 'a' + direction + 26) % 26)); //When shifting left (e.g., direction = -1), the index may become negative. To handle this, you should add 26 before taking % 26, ensuring the result is non-negative:

                sb.setCharAt(i, ch); // Update the character in the StringBuilder
            }
        }

        return sb.toString();
    }
}
```
# Optimised
```java
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        // Use StringBuilder for efficient string modifications
        StringBuilder sb = new StringBuilder(s);

        // Array to store the net shift to be applied at each index
        // Add 1 extra space to simplify handling end+1 cases
        int[] shiftCount = new int[s.length() + 1];

        // Iterate through each shift operation in the shifts array
        for (int[] shift : shifts) {
            int start = shift[0];   // Start index of the shift
            int end = shift[1];     // End index of the shift
            int d = shift[2] == 0 ? -1 : 1; // Direction: -1 for left, 1 for right

            // Increment shiftCount at the start index to apply the shift
            shiftCount[start] += d;

            // Decrement shiftCount at end+1 to cancel the shift after the end index
            if (end + 1 < s.length()) {
                shiftCount[end + 1] -= d;
            }
        }

        // Variable to track the cumulative shift as we traverse the string
        int cummulativeShift = 0;

        // Iterate through the StringBuilder to apply the cumulative shift to each character
        for (int i = 0; i < sb.length(); i++) {
            // Update cumulative shift by adding the value from shiftCount array
            cummulativeShift += shiftCount[i];

            // Get the current character from the StringBuilder
            char ch = sb.charAt(i);

            // Apply the cumulative shift to the character:
            // 1. Normalize 'ch' to its position in the alphabet: ch - 'a'
            // 2. Add the cumulative shift: (ch - 'a' + cummulativeShift)
            // 3. Use modulo 26 to wrap around the alphabet: % 26
            // 4. Add 26 to handle negative values: + 26
            // 5. Normalize back to a character: 'a' + result
            ch = (char) ('a' + ((ch - 'a' + cummulativeShift % 26 + 26) % 26));

            // Print the shifted character for debugging
            System.out.println(ch);

            // Update the character in the StringBuilder with the shifted value
            sb.setCharAt(i, ch);
        }

        // Convert the modified StringBuilder back to a string and return it
        return sb.toString();
    }
}

```
