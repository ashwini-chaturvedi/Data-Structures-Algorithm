```java
class Solution {

    //There is a Type of Window in which the Disturbing Elements are Present so we will Apply Sliding Window Technique to find out the shortest length of the sub array.
    public int findLengthOfShortestSubarray(int[] arr) {
        //Start Finding the Sorted Array from the Last of the given array this will give us the sorted Array that is still there
        //e.g arr=[1,2,3,10,4,2,3,5]; j will start moving backward from back

//Identify the largest sorted suffix from the end of the array.
        int j = arr.length - 1;
        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }
        //j is pointing at 2 which is at index 5 because subarray[2,3,5] are alredy sorted.

        if (j == 0) return 0; //if j reaches the index 0 which means array is already sorted.

//// Initialize the minimum length to the length of the unsorted suffix.
        //Start by considering that we have to Remove the Whole subarray from the End.
        int minLen = j; //Initially we consider to remove all the elements from j to the end of the array
        int i = 0; //for sliding Window
//Expand the sliding window from the beginning to merge with the sorted suffix that we have found using j.
        while (i < j && (i == 0 || arr[i] >= arr[i - 1])) { //Now start moving the Index i to check to the point where array is already sorted from the begining
            while (j < arr.length && arr[i] > arr[j]) { // Move j to find the correct position such that arr[i] <= arr[j]
                j++;
            }

            minLen = Math.min(minLen, j - i - 1); //Calculate the Minimum Length
            i++;
        }
        return minLen;
    }
}

```
