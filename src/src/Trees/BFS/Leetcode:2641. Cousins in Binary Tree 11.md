```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
/*
 Approach:
            1.At each level, it computes the sum of values of the child nodes (the next level's values).
            2.It then updates each node's value by subtracting its original value from the sum of values from the previous level. This creates a difference-based transformation, where each node's new value reflects the difference from its parent's level sum.
 */

    public TreeNode replaceValueInTree(TreeNode root) {
        // Use a queue for level-order traversal (Breadth-First Search)
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        // Initialize previous level's sum with the root node's value
        int prevLvlSum = root.val; // At the root level (level 0), the sum is the value of the root node itself

        // Continue level-order traversal until all levels are processed
        while (!que.isEmpty()) {
            int size = que.size(); // Number of nodes at the current level
            int currLvlSum = 0; // Sum of node values for the current level

            // Iterate over all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode ParentNode = que.poll(); // Dequeue a node (parent node at the current level)

                // Calculate the sum of the left and right child node values, if they exist
                int levelSum = (ParentNode.left != null ? ParentNode.left.val : 0) + (ParentNode.right != null ? ParentNode.right.val : 0);

                // Update the left child node's value if it exists
                if (ParentNode.left != null) {
                    // Set the left child's value to the sum of all child values at the current level
                    ParentNode.left.val = levelSum;
                    que.add(ParentNode.left); // Enqueue the left child for the next level
                }

                // Update the right child node's value if it exists
                if (ParentNode.right != null) {
                    // Set the right child's value to the sum of all child values at the current level
                    ParentNode.right.val = levelSum;
                    que.add(ParentNode.right); // Enqueue the right child for the next level
                }

                // Accumulate the sum for the current level
                currLvlSum += levelSum;

                // Update the current parent node's value
                // The new value is the difference between the sum of the previous level and the original node value
                ParentNode.val = prevLvlSum - ParentNode.val;
            }

            // Update previous level's sum for the next iteration
            // Now, prevLvlSum is the sum of all values at the current level, which will be used for the next level and there current level will be previous level
            prevLvlSum = currLvlSum;
        }

        // Return the modified tree
        return root;
    }
}
![image](https://github.com/user-attachments/assets/2600d862-215b-4251-8fcb-e31d5c07cef2)

```
