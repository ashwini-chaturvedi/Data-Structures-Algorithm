```java
class Solution {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();//if root is null

        List<Integer> list = new ArrayList<>();

        //BFS to find Max Value at Each Level.
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            int max = Integer.MIN_VALUE;//Check the maximum Value at current Level.
            while (size-- > 0) {
                TreeNode currNode = que.poll();
                max = Math.max(max, currNode.val);

                if (currNode.left != null) que.add(currNode.left);
                if (currNode.right != null) que.add(currNode.right);
            }
            list.add(max);//Add the Maximum Value into the List.
        }
        return list;
    }
}

```
