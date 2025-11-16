# Recursive
```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;

        if(root.val==val) return root;
        else if(root.val<val){
            return searchBST(root.right,val);
        }else{
           return searchBST(root.left,val);
        }
    }
}
```
# Iterative
```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode>que=new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            TreeNode node=que.poll();

            if(node==null) continue;
            if(node.val==val) return node;
            else if(node.val<val ){
                que.add(node.right);
            }else{
                que.add(node.left);
            }
        }

        return null;
    }
}
```
