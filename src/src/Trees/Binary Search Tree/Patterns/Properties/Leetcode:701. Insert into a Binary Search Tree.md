# Recursive
```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val > val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
}
```
```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);

        if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }else{
            root.right=insertIntoBST(root.right,val);
        }

        return root;
    }
}
```

```java
class Solution {
    public void DFS(TreeNode root,int target){
        if(root.val>target){
            if(root.left==null){
                //if the left child is null insert the newNode here 
                root.left=new TreeNode(target);
            }else{
                //or else try to found it in the left subtree as the target value is small then root value so we have to search it in left side...
                DFS(root.left,target);
            }
        }else{
            if(root.right==null){
                //similarly to above 
                root.right=new TreeNode(target);

            }else{
                //or else try to found it in the right subtree as the target value is greater then root value so we have to search it in left side...
                DFS(root.right,target);
            }
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        DFS(root,val);
        return root;
    }
}
```
