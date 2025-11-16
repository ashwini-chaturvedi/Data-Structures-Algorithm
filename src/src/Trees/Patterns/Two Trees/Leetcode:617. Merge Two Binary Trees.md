```java
class Solution {
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;

        TreeNode mergedNode=new TreeNode(root1.val+root2.val);

        mergedNode.left=mergeTrees(root1.left,root2.left);
        mergedNode.right=mergeTrees(root1.right,root2.right);

        return mergedNode;
    }
}
```
