```java
class Solution {
    //Searching in BST + if Found key then delete keeping 4 cases in mind
        //1. if root's left is null
        //2. if root's right is null
        //3. if root's both node (left,right) is null
        //4. if none side is null then find the lowest/minimum valued node in the right subtree to shift.

    public TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null && root.right == null) {
                return null;
            } else {
                TreeNode succesorNode = findMin(root.right);
                root.val = succesorNode.val;
                root.right = deleteNode(root.right, succesorNode.val);
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }
}

```
