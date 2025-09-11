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

    public void levelOrderTraversal(TreeNode root) {
        int level = 0;

        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<TreeNode> currLevel = new ArrayList<>();//To Collect the nodes of odd level
            while (size-- > 0) {
                TreeNode curr = que.poll();

                currLevel.add(curr);//Collect the References of the Nodes that are in Tree.

                if (curr.left != null) que.add(curr.left);
                if (curr.right != null) que.add(curr.right);
            }
            if (level % 2 != 0) {//if the level is Odd 
            //Use Two Pointers to swap the Values of the Nodes so that it appears that nodes are Swapped
                int left = 0;
                int right = currLevel.size() - 1;

                while (left < right) {
                    int temp = currLevel.get(left).val;
                    currLevel.get(left).val = currLevel.get(right).val;
                    currLevel.get(right).val = temp;

                    left++;
                    right--;
                }
            }
            level++;//Increase the level...
        }
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        levelOrderTraversal(root);
        return root;
    }
}

```
