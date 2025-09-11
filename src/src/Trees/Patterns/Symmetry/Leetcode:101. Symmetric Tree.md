![](https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg)
```java
class Solution {
    public boolean Symmetry(TreeNode left,TreeNode right){
        if(left==null || right==null) return left==right;

        if(left.val !=right.val) return false;

⚠️Important: The way of movement to left of left and right of right & right of left and left of right
        return Symmetry(left.left,right.right) && Symmetry(left.right,right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return Symmetry(root.left,root.right);
    }
}
```
