```java
class Solution {

    public boolean isCompleteTree(TreeNode root) {
        boolean seenNull = false;

        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();

            if (node != null && seenNull) return false;

            //we had problem ki jb hm level by level traverse krrhe h aur kisi level pe left node ka left child toh null nhi h but right h but right node pe left child null nhi h mtlb row me pehle null aaya aur baad me nhi toh yeh complete BT hai nhi so hm point out krenge ki null mila ki nhi 
            if (node != null) {
                que.add(node.left);
                que.add(node.right);
            } else {
                seenNull = true;
            }
        }

        return true;
    }
}

```
