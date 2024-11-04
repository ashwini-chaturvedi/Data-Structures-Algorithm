```java
class Solution {

    /**
     * Compresses a given string by grouping consecutive occurrences of the same character.
     * If a character is repeated more than 9 times consecutively, it resets the count and 
     * starts a new sequence with the same character.
     * 
     * Example:
     * "aaabbbccccccccc" -> "3a3b9c3c"
     *
     * @param word the input string to be compressed
     * @return the compressed string
     */
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder(); // Result string builder
        int currCount = 0; // Counter for consecutive characters
        char currChar = word.charAt(0); // Initialize with the first character in the word

        // Loop over each character in the word
        for (char ch : word.toCharArray()) {
            // If the current character is the same as the previous character
            if (ch == currChar) {
                // If count reaches 9, add the count and character to the result, then reset count
                if (currCount >= 9) {
                    sb.append(currCount).append(currChar);
                    currCount = 0;
                }
                currCount++; // Increment count for current character
            } else {
                // Append the count and character to the result for the previous group
                sb.append(currCount).append(currChar);
                currCount = 1; // Reset count for the new character group
                currChar = ch; // Update current character to the new one
            }
        }

        // Append the last character group to the result
        sb.append(currCount).append(currChar);
        return sb.toString();
    }
}
```
