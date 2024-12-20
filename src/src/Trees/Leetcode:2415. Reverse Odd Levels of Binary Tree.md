# DFS Approach
```java
class Solution {

    public void DFS(TreeNode left,TreeNode right,int level) {
        if(left==null && right==null ) return;

        if(level%2!=0){//Reverse values at odd level
            int temp=left.val;
            left.val=right.val;
            right.val=temp;
        }

        //IMPORTANT POINT...
        DFS(left.left,right.right,level+1);//left ka left aur right ka right are connected for Reversing
        DFS(left.right,right.left,level+1);//left ka right and right ka left are connected for Reversing
        //Try to Visulaize this connection by Drawing a Tree Representation
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        
        DFS(root.left,root.right,1);//since the root node is at level 0 so we will start from level 1 because we have already include the root node.
        return root;
    }
}
```
# Level-Order Traversal (MY APPROACH)
```java
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
