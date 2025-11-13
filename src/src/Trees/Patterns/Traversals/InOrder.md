# Iterative
```java

class Solution {
    public void traverse(TreeNode root, List<Integer> list) {
        if(root==null) return;
        Stack<TreeNode> st = new Stack<>();

        while (true) {
            while (root != null) {
                
                st.push(root);
                root = root.left;
                
            }
            if (st.isEmpty()) break;


            root = st.pop();
            list.add(root.val);//Adding the root before right subtree
            root=root.right;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
}
```

# Recursive
```java
class Solution {
    public void inOrder(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        inOrder(root,list);
        return list;
    }
}
```
