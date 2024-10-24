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

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        //When values of roots are equal
        if (root1.val == root2.val) {
            //we have to check if it will be equivalent when
            //1.No-Flip
            //2.Flip
            boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);

            boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

            return noFlip || flip; //if the Tree's are equivalent in either ways return it.wheather the tree is equivalent in doing no flip or wheather with flip.
        }

        return false; //if root's values are not equal then it cannot be equivalent in any way
    }
}


```
