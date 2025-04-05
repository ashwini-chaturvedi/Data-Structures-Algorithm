Given the root of a binary tree, the depth of each node is the shortest distance to the root.

Return the smallest subtree such that it contains all the deepest nodes in the original tree.

A node is called the deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation: We return the node with value 2, colored in yellow in the diagram.
The nodes coloured in blue are the deepest nodes of the tree.
Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2 is the smallest subtree among them, so we return it.

```java

class Solution {

    public int MaxDepth(TreeNode root) {//finding the depth of the BT
        if (root == null) return 0;

        return 1 + Math.max(MaxDepth(root.left), MaxDepth(root.right));
    }

    public TreeNode solve(TreeNode root, int maxDepth, int currLen) {
        if (root == null) {
            return null;
        }

        if (currLen == maxDepth - 1) return root;//if reached the LCA of deepest leaf 

        //Post-order Traversal
        TreeNode left = solve(root.left, maxDepth, currLen + 1);
        TreeNode right = solve(root.right, maxDepth, currLen + 1);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root; //both left and right are not null so we have found the answer
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {

        //Find the depth of the tree and then the LCA of deepest leaf node would be at 'depth-1'
        int maxDepth = MaxDepth(root);
        return solve(root, maxDepth, 0);
    }
}

```
