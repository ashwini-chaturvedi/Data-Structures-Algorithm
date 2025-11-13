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
    public int Traverse(TreeNode root,int[] count){
         if(root==null) return 0;

        int left=Traverse(root.left,count);
        int right=Traverse(root.right,count);

        int sum=left+right;//sum of left subtree

        count[0]=Math.max(count[0],sum);//maximum length of the path

        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
       int[] count={0};
       Traverse(root,count);
       return count[0];
    }
}
```
