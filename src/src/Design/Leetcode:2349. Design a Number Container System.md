Design a number container system that can do the following:

Insert or Replace a number at the given index in the system.
Return the smallest index for the given number in the system.
Implement the NumberContainers class:

NumberContainers() Initializes the number container system.
void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.
 

Example 1:

Input
["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
[[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
Output
[null, -1, null, null, null, null, 1, null, 2]

Explanation
NumberContainers nc = new NumberContainers();
nc.find(10); // There is no index that is filled with number 10. Therefore, we return -1.
nc.change(2, 10); // Your container at index 2 will be filled with number 10.
nc.change(1, 10); // Your container at index 1 will be filled with number 10.
nc.change(3, 10); // Your container at index 3 will be filled with number 10.
nc.change(5, 10); // Your container at index 5 will be filled with number 10.
nc.find(10); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20. 
nc.find(10); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.

```java
import java.util.*;

class NumberContainers {
    // Maps each index to its assigned number
    Map<Integer, Integer> idxEle;

    // Maps each number to a sorted set of indices where it appears
    Map<Integer, TreeSet<Integer>> eleIdx;

    public NumberContainers() {
        idxEle = new HashMap<>();       // Stores index -> number mappings
        eleIdx = new HashMap<>();       // Stores number -> sorted indices
    }

    /**
     * Updates the value at a given index with a new number.
     * If the index already has a number assigned, it removes the old number's reference.
     * Then, it updates the new number in both maps.
     *
     * @param index  The index to be updated.
     * @param number The new number to assign to the index.
     */
    public void change(int index, int number) {
        // Check if the index is already assigned a number
        if (idxEle.containsKey(index)) {
            int oldNumber = idxEle.get(index);
            // Remove index from the previous number's set
            if (eleIdx.containsKey(oldNumber)) {
                eleIdx.get(oldNumber).remove(index);
                // If no indices remain for this number, remove its entry
                if (eleIdx.get(oldNumber).isEmpty()) {
                    eleIdx.remove(oldNumber);
                }
            }
        }

        // Update index with the new number
        idxEle.put(index, number);

        // Add the index to the set corresponding to the new number
        eleIdx.putIfAbsent(number, new TreeSet<>()); // Ensure a TreeSet exists for this number
        eleIdx.get(number).add(index); // Add index to the sorted set
    }

    /**
     * Finds the smallest index where a given number appears.
     *
     * @param number The number whose smallest index is to be found.
     * @return The smallest index where the number appears, or -1 if the number does not exist.
     */
    public int find(int number) {
        // If the number is not present or has no valid indices, return -1
        if (!eleIdx.containsKey(number) || eleIdx.get(number).isEmpty()) {
            return -1;
        }
        return eleIdx.get(number).first(); // Retrieve the smallest index in O(1) time
    }
}

```
