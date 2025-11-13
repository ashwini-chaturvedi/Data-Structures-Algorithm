# Iterative
```java
class Solution {

    public void traverse(TreeNode root, List<Integer> list) {
        if(root==null) return;
        Stack<TreeNode> st = new Stack<>();

        while (true) {
            while (root != null) {
                list.add(root.val);
                st.push(root);
                root = root.left;
                
            }
            if (st.isEmpty()) break;


            root = st.pop();
            root=root.right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
}

```

# Recursive
```java
class Solution {
    public void traverse(TreeNode root,List<Integer>list){
        if(root==null) return;

        list.add(root.val);
        traverse(root.left,list);
        traverse(root.right,list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        traverse(root,list);
        return list;
    }
}
```
