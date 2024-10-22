#Code + Approach
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        // minHeap=>Largest Number
        // maxHeap=>Smallest Number
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        while (!que.isEmpty()) {//LEVEL order Traversal or BFS
            int size = que.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = que.poll();
                sum += currNode.val;
                if (currNode.left != null) {
                    que.add(currNode.left);
                }
                if (currNode.right != null) {
                    que.add(currNode.right);
                }
            }
            if (minHeap.size() < k) {
                // If the heap has fewer than k elements, add the current sum
                minHeap.add(sum);
            } else if (sum > minHeap.peek()) {
                // If the heap is full (size == k) and the current sum is larger than the
                // smallest in the heap
                minHeap.poll(); // Remove the smallest element
                minHeap.add(sum); // Add the current larger sum
            }

        }
        return minHeap.size() == k ? minHeap.peek() : -1;
    }
}
```
