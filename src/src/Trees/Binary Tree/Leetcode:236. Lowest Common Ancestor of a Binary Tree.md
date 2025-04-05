Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:

![img](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

![img](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

```java
class Solution {
    // 1. any node is returning null means at that path none of the p and q are to be seen 
    // 2. as soon as we found root is equal to p or q we return that node.
    // 3. we will return null from a subtree because we haven't found either p or q
    // if there is one child null and the other is not then we have to take the other child 
    public TreeNode solve(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left=solve(root.left,p,q);
        TreeNode right=solve(root.right,p,q);
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;//both left and right are not null so we have found the answer
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans=solve(root,p,q);
        return ans;
    }
}
```
