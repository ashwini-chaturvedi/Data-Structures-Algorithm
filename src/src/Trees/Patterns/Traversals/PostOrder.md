# Iterative
## first do the modified Pre-order(root->right->left) then reverse it so we will get postorder (left->right->root)
```java
class Solution {
    public List<Integer> traverse(TreeNode root){
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();

        if(root==null) return list;

        while(true){
            while(root!=null){
                list.add(root.val);
                st.push(root);
                root=root.right;
            }
            if(st.isEmpty()) break;

            root=st.pop();
            root=root.left;
        }

         Collections.reverse(list);
         return list;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        return traverse(root);
    }
}
```

# Recursive
```java
class Solution {
    public void solve(TreeNode root,List<Integer>list){
        if(root==null) return;
        solve(root.left,list);
        solve(root.right,list);
        list.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        solve(root,list);
        return list;
    }
}
```
