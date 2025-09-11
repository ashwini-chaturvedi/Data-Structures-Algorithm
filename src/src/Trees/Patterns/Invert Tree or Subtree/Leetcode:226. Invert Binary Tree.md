```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            TreeNode curr=que.poll();

            // swap children of the current node which will be seen as whole tree is inverted...
            //if nodes on any particular level is to be inverted then we would have to store nodes on that level and then invert it...
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.left!=null) que.add(curr.left);
            if(curr.right!=null) que.add(curr.right);
           
        }

        return root;
    }
}
```
