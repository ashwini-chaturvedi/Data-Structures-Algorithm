package Trees;

import java.util.Stack;

public class inOrderTraversal {
    public static void inOrderRecursive(TreeNode root){
        if(root==null){
            return;
        }
        inOrderRecursive(root.left);
        System.out.print(root.val+",");
        inOrderRecursive(root.right);
    }
    public static void inOrderIterative(TreeNode root){
        Stack<TreeNode>st=new Stack<>();
        while(true){
            if(root!=null){
                st.push(root);
                root=root.left;
            }else{
                if(st.isEmpty()){
                    break;
                }
                root=st.pop();
                System.out.print(root.val+",");
                root=root.right;
            }
        }
    }
    public static void main(String[]args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        inOrderRecursive(root);
        System.out.println();
        inOrderIterative(root);
    }
}
