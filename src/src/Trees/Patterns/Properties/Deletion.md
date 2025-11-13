```java
// 1.find the Target Node
// 2.find the Deepest Node
// 3.change the value of target node with value of deepest Node
// 4.now delete the deepest Node 
class Solution {
    public Node searchNode(Node root,int target){
        Queue<Node>que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            Node node=que.poll();
            
            if(node.data==target) return node;
            
            if(node.left!=null) que.add(node.left);
            if(node.right!=null) que.add(node.right);
            
        }
        return null;
    }
    public Node seachNodeDeepest(Node root){
        Queue<Node>que=new LinkedList<>();
        que.add(root);
        Node node=null;
        while(!que.isEmpty()){
            node=que.poll();
            
            if(node.left!=null) que.add(node.left);
            if(node.right!=null) que.add(node.right);
            
        }
        return node;
    }
    
    public void deleteDeepestNode(Node root,Node nodeToDel){
        Queue<Node>que=new LinkedList<>();
        
        que.add(root);
        while(!que.isEmpty()){
            Node node=que.poll();
            
            if(node.left!=null){
                if(node.left==nodeToDel){
                    node.left=null;
                    return ;
                }else{
                    que.add(node.left);
                }
            }
            if(node.right!=null){
                if(node.right==nodeToDel){
                    node.right=null;
                    return ;
                }else{
                    que.add(node.right);
                }
            }
        }
    }
    public Node deleteNode(Node root, int key) {
        Node nodeToDel=searchNode(root,key);
        if(nodeToDel==null) return root;
        
        Node deepestNode=seachNodeDeepest(root);
        
        nodeToDel.data=deepestNode.data;
        
        
        deleteDeepestNode(root,deepestNode);
        
        return root;
        
    }
}
```
