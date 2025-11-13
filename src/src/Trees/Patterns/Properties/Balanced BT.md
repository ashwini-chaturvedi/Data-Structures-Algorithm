```java
class Solution {

    public int balance(TreeNode root, boolean[] isNotBalance) {
        if (root == null) {
            return 0;
        }

        int left = balance(root.left, isNotBalance);
        if (left == -1) {
            return -1;
        }
        int right = balance(root.right, isNotBalance);
        if (right == -1) {
            return -1;
        }

        int diff = Math.abs(left - right);

        if (diff > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        boolean[] isNotBalance = { false };
        int deg = balance(root, isNotBalance);

        return deg == -1 ? false : true;
    }
}

```
