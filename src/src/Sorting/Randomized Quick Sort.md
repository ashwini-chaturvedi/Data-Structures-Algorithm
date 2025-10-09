```java
//Randomized Quick Sort
class Solution {

    Random random = new Random();

    // Pick a random pivot index between start and end
    public int randomizedPivot(int start, int end) {
        return random.nextInt(end - start + 1) + start;
    }

    // Partition function (Lomuto partition scheme)
    public int partition(int[] nums, int start, int end) {
        int pivotIdx = randomizedPivot(start, end);

        // Move pivot element to the end
        int temp = nums[pivotIdx];
        nums[pivotIdx] = nums[end];
        nums[end] = temp;

        int pivotValue = nums[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (nums[j] <= pivotValue) {
                i++;
                int swap = nums[i];
                nums[i] = nums[j];
                nums[j] = swap;
            }
        }

        // Place pivot at correct position
        int swap = nums[i + 1];
        nums[i + 1] = nums[end];
        nums[end] = swap;

        return i + 1;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivotIdx = partition(nums, start, end);

            quickSort(nums, start, pivotIdx - 1);
            quickSort(nums, pivotIdx + 1, end);
        }
    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
}

```
