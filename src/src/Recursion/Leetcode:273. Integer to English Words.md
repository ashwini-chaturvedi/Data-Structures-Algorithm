```java
import java.util.*;

class Solution {

    // Helper function to convert a number into its corresponding English words representation.
    public String solve(int num, Map<Integer, String> belowTen, Map<Integer, String> belowTwenty, Map<Integer, String> belowHundred) {
        // Base case: if the number is less than 10, directly return its word representation.
        if (num < 10) return belowTen.get(num);

        // If the number is between 10 and 19, return the corresponding word from the belowTwenty map.
        if (num < 20) return belowTwenty.get(num);

        // If the number is between 20 and 99, split it into tens and units.
        if (num < 100) {
            // Get the tens part using integer division (num / 10) and retrieve the word from belowHundred.
            // Get the units part using modulo (num % 10) and append its word representation if it's not zero.
            return belowHundred.get(num / 10) + (num % 10 != 0 ? " " + belowTen.get(num % 10) : "");
        }

        // If the number is between 100 and 999, handle the hundreds place.
        if (num < 1000) {
            // Recursively convert the hundreds part (num / 100) and append "Hundred".
            // If there is a remainder (num % 100), recursively convert it as well.
            return solve(num / 100, belowTen, belowTwenty, belowHundred) + " Hundred" + 
                   (num % 100 != 0 ? " " + solve(num % 100, belowTen, belowTwenty, belowHundred) : "");
        }

        // If the number is between 1,000 and 999,999, handle the thousands place.
        if (num < 1000000) {
            // Recursively convert the thousands part (num / 1000) and append "Thousand".
            // If there is a remainder (num % 1000), recursively convert it as well.
            return solve(num / 1000, belowTen, belowTwenty, belowHundred) + " Thousand" + 
                   (num % 1000 != 0 ? " " + solve(num % 1000, belowTen, belowTwenty, belowHundred) : "");
        }

        // If the number is between 1,000,000 and 999,999,999, handle the millions place.
        if (num < 1000000000) {
            // Recursively convert the millions part (num / 1,000,000) and append "Million".
            // If there is a remainder (num % 1,000,000), recursively convert it as well.
            return solve(num / 1000000, belowTen, belowTwenty, belowHundred) + " Million" + 
                   (num % 1000000 != 0 ? " " + solve(num % 1000000, belowTen, belowTwenty, belowHundred) : "");
        }

        // If the number is greater than or equal to 1,000,000,000, handle the billions place.
        // Recursively convert the billions part (num / 1,000,000,000) and append "Billion".
        // If there is a remainder (num % 1,000,000,000), recursively convert it as well.
        return solve(num / 1000000000, belowTen, belowTwenty, belowHundred) + " Billion" + 
               (num % 1000000000 != 0 ? " " + solve(num % 1000000000, belowTen, belowTwenty, belowHundred) : "");
    }

    // Main function to convert a number to English words.
    public String numberToWords(int num) {
        // Edge case: if the number is 0, return "Zero".
        if (num == 0) return "Zero";

        // Maps to store word representations for numbers below 10, below 20, and multiples of 10.
        Map<Integer, String> belowTen = new HashMap<>();
        belowTen.put(0, "");
        belowTen.put(1, "One");
        belowTen.put(2, "Two");
        belowTen.put(3, "Three");
        belowTen.put(4, "Four");
        belowTen.put(5, "Five");
        belowTen.put(6, "Six");
        belowTen.put(7, "Seven");
        belowTen.put(8, "Eight");
        belowTen.put(9, "Nine");

        Map<Integer, String> belowTwenty = new HashMap<>();
        belowTwenty.put(10, "Ten");
        belowTwenty.put(11, "Eleven");
        belowTwenty.put(12, "Twelve");
        belowTwenty.put(13, "Thirteen");
        belowTwenty.put(14, "Fourteen");
        belowTwenty.put(15, "Fifteen");
        belowTwenty.put(16, "Sixteen");
        belowTwenty.put(17, "Seventeen");
        belowTwenty.put(18, "Eighteen");
        belowTwenty.put(19, "Nineteen");

        Map<Integer, String> belowHundred = new HashMap<>();
        belowHundred.put(1, "Ten");
        belowHundred.put(2, "Twenty");
        belowHundred.put(3, "Thirty");
        belowHundred.put(4, "Forty");
        belowHundred.put(5, "Fifty");
        belowHundred.put(6, "Sixty");
        belowHundred.put(7, "Seventy");
        belowHundred.put(8, "Eighty");
        belowHundred.put(9, "Ninety");

        // Use the helper function to convert the number into words.
        return solve(num, belowTen, belowTwenty, belowHundred);
    }
}

```
