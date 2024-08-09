package Trees;

import java.util.Stack;

public class preOrderTraversal {
    public static void preOrdeRecursive(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+",");
        preOrdeRecursive(root.left);
        preOrdeRecursive(root.right);
    }
    public static void preOrdeIterative(TreeNode root){
        Stack<TreeNode>st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            System.out.print(node.val+",");
            if(node.right!=null){
                st.push(node.right);
            }
            if(node.left!=null){
                st.push(node.left);
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
        preOrdeRecursive(root);
        System.out.println();
        preOrdeIterative(root);
    }
}
