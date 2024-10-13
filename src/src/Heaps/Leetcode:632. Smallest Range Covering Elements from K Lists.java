//Approach:1 Using Heap
//Time Complexity:O(n*logk)
//We wil Use a MinHeap to get the Minimum value at constant time.
class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        //MinHeap to Store:(value,listIndex,ElementIndex).
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int maxEl = Integer.MIN_VALUE;

        //add first k elements into the minheap
        for (int i = 0; i < k; i++) {
             minHeap.add(new int[] { nums.get(i).get(0),      i,          0         });
                                // (    value,              listIdx,  ElementIdx    )
            maxEl = Math.max(maxEl, nums.get(i).get(0)); //Maintaining the maximumElement.
        }

        int[] resultRange = { -1000000, 1000000 };

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            int currMinEl = curr[0]; //currEl=minEl
            int currListIdx = curr[1]; //currListIdx=Listidx
            int currElIdx = curr[2];

            int currentRange = maxEl - currMinEl;
            int previousRange = resultRange[1] - resultRange[0];
            //If current Range is less than the previously found minumum range update the value.
            if (currentRange < previousRange) {
                resultRange[0] = currMinEl;
                resultRange[1] = maxEl;
            }

            //Now Decresing the range by moving the minElPointer to the Next element
            int nextIdx = currElIdx + 1;
            if (nextIdx >= nums.get(currListIdx).size()) {
                break;//If the Index is Out of Bound break the Loop.
            } else {
                int nextEl = nums.get(currListIdx).get(nextIdx);
                minHeap.add(new int[] { nextEl, currListIdx, nextIdx });
                maxEl = Math.max(maxEl, nextEl);
            }
        }
        return resultRange;
    }
}
//Approach:2 Using Array to Store the Index
//Time Complexity:O(n*k)
class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
//This will Keep track of the current Index for each list.
        int[] pointers = new int[k]; //To store 'k' pointers that will point an element in each list.

        // Initialize the result range with extreme values
        int[] resultRange = { -1000000, 1000000 };

        while (true) {
            int minEl = Integer.MAX_VALUE;
            int maxEl = Integer.MIN_VALUE;
            int minElIdx = 0;//Minimum Element Index
//Find the Minimum and Maximum Elements among the current elements in the k lists
            for (int i = 0; i < k; i++) {
                int elIdx = pointers[i];
                int element = nums.get(i).get(elIdx);

                if (element < minEl) {//Checking for Minimum Element.
                    minElIdx = i;
                    minEl = element;
                }

                maxEl = Math.max(maxEl, element);//updating the Maximum Element.
            }

            int currentRange = maxEl - minEl;
            int previousRange = resultRange[1] - resultRange[0];
//If the current range is smaller then the Previously found possible smaller range,update the result range to the current range 
            if (currentRange < previousRange) {
                resultRange[0] = minEl;
                resultRange[1] = maxEl;
            }
//Moving to the next element in the List that had the minimum value that is why only minElIdx is updated 
            int nextIdx = pointers[minElIdx] + 1;//Moving to the next pointer in the minEl list.
            if (nextIdx >= nums.get(minElIdx).size()) {//Checking the size of the minElIdx
                break;//if the index goes out of bound for any list break the loop because now if we do the operations possibly no element of this list will be in the answer and hence break the loop.
            }
            pointers[minElIdx] = nextIdx;//update the minIndex.
        }
        return resultRange;
    }
}
