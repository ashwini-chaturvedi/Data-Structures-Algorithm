/*Approach:
 1.Use a Stack to store the Pair of value and index.
 2.Use that Stack to store the value Monotonically Increasing from top to bottom by pushing the values that are smaller than the value at top with there respective Indices.
 3.if found any value that is grater than the number at top then start transfering values from main stack to Temporary stack while doing this calculate the maximum width of the ramp.
 4.we are doing step 3 because:A "ramp is a pair (i,j) for which
                                a) i<j
                                b) nums[i]<=nums[j]
                                c) width= j-i"
 5. That is why we want to have a smaller number at top and larger at bottom. 
*/
class Solution {

    public int maxWidthRamp(int[] nums) {
        Stack<int[]> stack = new Stack<>(); // Store pairs of {value, index}
        int maxWidth = Integer.MIN_VALUE; //For finding the maxWidth

        // Initialize stack with the first element and its index
        stack.add(new int[] { nums[0], 0 });

        for (int i = 1; i < nums.length; i++) {
            if (stack.peek()[0] > nums[i]) {
            // If the current element is smaller than the top of the stack, add it to the stack
                stack.push(new int[] { nums[i], i });
            } else {
                Stack<int[]> st = new Stack<>();
                // Calculate width by popping elements from the stack where top < current element
                while (!stack.isEmpty() && stack.peek()[0] <= nums[i]) {
                    int[] curr = stack.pop();
                    maxWidth = Math.max(maxWidth, (i - curr[1]));
                    st.push(curr); // Save popped elements to restore later
                }
                // Restore elements to the stack, preserving previous starts
                while (!st.isEmpty()) {
                    stack.push(st.pop());
                }
            }
        }
        // If no valid ramp found, return 0
        return maxWidth == Integer.MIN_VALUE ? 0 : maxWidth;
    }
}
