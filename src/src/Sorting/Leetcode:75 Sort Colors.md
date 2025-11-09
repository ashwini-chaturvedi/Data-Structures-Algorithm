## Most Optimized (3 Pointer)
Time Complexity:O(N)
Space Complexity:O(1)
```java
//Dutch National Flag Algorithm-3Pointer because we only have 3 values 0 1 2
class Solution {
    public void sortColors(int[] nums) {
        //using 3 Pointers to track zero,one & two.
        int zero = 0;
        int one = 0;
        int two = nums.length - 1;

        while(one<=two){
            if (nums[one] == 0) {//when found zero swap it with zeroptr and move both pointers
                int temp = nums[one];
                nums[one] = nums[zero];
                nums[zero] = temp;
                zero++;
                one++;
            } else if (nums[one] == 2) {//when found two swap it with twoptr and move two pointer one step back but dont move oneptr because element on the twoptr can either be zero or one so for that we have to take care so dont move oneptr.
                int temp = nums[one];
                nums[one] = nums[two];
                nums[two] = temp;
                two--;
            } else {//if found one move the oneptr
                one++;
            }
        }
    }
}

```

## Randomized Quick Sort
Time Complexity:O(NlogN)
Space Complexity:O(1)
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
