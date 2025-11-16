```java
class Solution {
    public static boolean isSimilar(Node root,Node S){
        if(root==null && S==null) return true;
        if(root==null || S==null) return false;
        
        
        return root.data==S.data &&
        isSimilar(root.left,S.left) && 
        isSimilar(root.right,S.right);
    }
    public static boolean isSubtree(Node T, Node S) {
        //Search the Target Node which is the first Node in the Second Tree.
        //Now Traverse along the 2nd Tree
        Queue<Node> q = new LinkedList<>();
        q.add(T);

        while (!q.isEmpty()) {
            Node node = q.poll();
    
            if (node.data == S.data) {//if data is similar the first Node of second tree
                if (isSimilar(node, S)) return true;
            }
    
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }

        return false;
    }
}
```
