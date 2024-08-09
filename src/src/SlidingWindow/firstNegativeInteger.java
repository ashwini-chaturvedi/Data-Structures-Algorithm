package SlidingWindow;
import java.util.*;

public class firstNegativeInteger {
    //ArrayImplementation
    public static List<Long> FirstNegativeInteger(long[] A, long N, long k) {
        List<Long> result = new ArrayList<>();
        long[] window = new long[(int)k];
        int windowIdx = 0; // Pointer to the current position in the window
        int i = 0, j = 0;

        while (j < N) {
            if (A[j] < 0) {
                window[windowIdx] = A[j];
            }

            if (j - i + 1 == k) {
                long neg = window[0] == 0 ? 0 : window[0];
                result.add(neg);
                if (A[i] < 0 && windowIdx > 0) {
                    // Shift elements to the left to remove the first element of the window
                    for (int m = 0; m < windowIdx; m++) {
                        window[m] = window[m + 1];
                    }
                    windowIdx--;
                }
                i++;
            }
            j++;
            windowIdx = (int)(j % k); // Update the pointer in the window
        }
        return result;
    }

    //linked list implementation...
    public static List<Long> printFirstNegativeInteger(long[] A, long N, long k) {
        List<Long> result = new ArrayList<>();
        LinkedList<Long> linkedList = new LinkedList<>();
        int i = 0, j = 0;

        while (j < N) {
            if (A[j] < 0)//if the element is negative add it to the list
                linkedList.add(A[j]);//calculation for the j pointer
            if (j - i + 1 == k) {
                long neg = linkedList.isEmpty() ? 0 : linkedList.getFirst(); //if the list is empty assign value zero otherwise assign first value of the list.
                result.add(neg);
                if (A[i] < 0 && !linkedList.isEmpty()) {
                    linkedList.removeFirst();
                }
                i++;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        long[] A = {12, -1, -7, 8, -15, 30, 16, 28};
        long N = A.length;
        long k = 3;
        List<Long> result = printFirstNegativeInteger(A, N, k);
        System.out.println(result);
    }

    public static class SlidingWindow {
        // Java code for
    // O(n) solution for finding
    // maximum sum of a subarray
    // of size k


            // Returns maximum sum in
            // a subarray of size k.
            static int maxSum(int arr[], int n, int k)
            {
                // n must be greater
                if (n < k) {
                    System.out.println("Invalid");
                    return -1;
                }

                // Compute sum of first window of size k
                int max_sum = 0;
                for (int i = 0; i < k; i++)
                    max_sum += arr[i];

                // Compute sums of remaining windows by
                // removing first element of previous
                // window and adding last element of
                // current window.
                int window_sum = max_sum;
                for (int i = k; i < n; i++) {
                    window_sum += arr[i] - arr[i - k];
                    max_sum = Math.max(max_sum, window_sum);
                }

                return max_sum;
            }

            // Driver code
            public static void main(String[] args)
            {
                int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
                int k = 4;
                int n = arr.length;
                System.out.println(maxSum(arr, n, k));
            }
        }
}


