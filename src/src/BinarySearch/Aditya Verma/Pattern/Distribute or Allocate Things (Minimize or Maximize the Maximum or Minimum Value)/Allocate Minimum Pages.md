You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
[12] and [34, 67, 90] Maximum Pages = 191
[12, 34] and [67, 90] Maximum Pages = 157
[12, 34, 67] and [90] Maximum Pages = 113.
Therefore, the minimum of these cases is 113, which is selected as the output.

```java
class Solution {

    // Helper function to check if a given maximum number of allowed pages (`allowedPages`)
    // can be allocated to the given number of students (`Students`) while satisfying the constraints.
    public static boolean isValid(int[] Books, int Students, int allowedPages) {
        int student = 1; // Start with the first student
        int sum = 0; // Current sum of pages assigned to the current student

        for (int i = 0; i < Books.length; i++) {
            sum += Books[i]; // Add the current book's pages to the sum

            // If the sum exceeds the allowed number of pages:
            if (sum > allowedPages) {
                student++; // Allocate books to the next student
                sum = Books[i]; // Start the new student's allocation with the current book

                // If the number of students exceeds the given limit, return false
                if (student > Students) {
                    return false;
                }
            }
        }
        return true; // All books are allocated within the constraints
    }

    // Function to find the minimum number of pages that can be allocated to students such that:
    // 1. Each student gets a contiguous segment of books.
    // 2. The maximum number of pages assigned to any student is minimized.
    public static int findPages(int[] Books, int Students) {
        // Edge case: If there are fewer books than students, it's impossible to allocate, return -1
        if (Books.length < Students) return -1;

        int low = 0; // The minimum number of pages that can be assigned (minimum of a single book's pages)
        int high = 0; // The maximum number of pages that can be assigned (sum of all book pages)

        // Initialize the `low` and `high` bounds
        for (int pages : Books) {
            low = Math.max(low, pages); // The minimum allocation must accommodate the largest book
            high += pages; // Sum of all pages is the maximum possible allocation
        }

        int res = -1; // Variable to store the final result

        // Binary search to find the minimum "maximum number of pages"
        while (low <= high) {
            int mid = low + (high - low) / 2; // Midpoint of the current search range

            // Check if the current `mid` value is a valid allocation
            if (isValid(Books, Students, mid)) {
                res = mid; // Update result as a potential answer
                high = mid - 1; // Try for a smaller maximum by reducing the search range
            } else {
                low = mid + 1; // Increase the search range to try for a larger maximum
            }
        }

        return res; // Return the minimum "maximum number of pages"
    }
}

```
