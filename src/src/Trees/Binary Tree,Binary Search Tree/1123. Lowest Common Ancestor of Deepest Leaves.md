Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.

Recall that:

The node of a binary tree is a leaf if and only if it has no children
The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.
 

Example 1:
![img](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/01/sketch1.png)


Input: root = [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation: We return the node with value 2, colored in yellow in the diagram.
The nodes coloured in blue are the deepest leaf-nodes of the tree.
Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2, but the depth of nodes 7 and 4 is 3.

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
