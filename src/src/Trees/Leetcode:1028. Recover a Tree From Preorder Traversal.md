We run a preorder depth-first search (DFS) on the root of a binary tree.

At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.

If a node has only one child, that child is guaranteed to be the left child.

Given the output traversal of this traversal, recover the tree and return its root.

![img](https://assets.leetcode.com/uploads/2024/09/10/recover_tree_ex3.png)
Input: traversal = "1-401--349---90--88"
Output: [1,401,null,349,88,90]
```java
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();
        
        while (i < n) {
            int depth = 0;
            
            // Count dashes to determine depth
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Read number (could be multiple digits)
            int num = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                num = num * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode newNode = new TreeNode(num);

            // If depth == stack size, it means it's a left child.
            // Otherwise, we pop until the correct parent is found.
            while (stack.size() > depth) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = newNode;
                } else {
                    stack.peek().right = newNode;
                }
            }

            stack.push(newNode); // Push the new node onto the stack
        }

        // Root is at the bottom of the stack
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }
}

```
