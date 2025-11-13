## Half node:Nodes which only have one child 
```java
/*

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

*/

class Solution {
    // Return the root of the modified tree after removing all the half nodes.
    public Node RemoveHalfNodes(Node root) {
        if(root==null) return null;
        
        //Jo bhi return hoga ya toh woh Leaf node hoga ya fir aisa node hoga jo half na ho 
        root.left=RemoveHalfNodes(root.left);
        root.right=RemoveHalfNodes(root.right);
        
        if(root.left==null && root.right==null){
            return root;
        }
        
        //jb koi half node mile toh uska woh wala part return kro jo ki null nhi h 
        if(root.left==null){
            return root.right;
        }
        if(root.right==null){
            return root.left;
        }
        
        return root;
        
    }
}
```
