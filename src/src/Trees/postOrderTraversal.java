package Trees;

import java.util.Stack;

public class postOrderTraversal {
    public static void postOrderRecursive(TreeNode root){
        if(root==null){
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.val+",");
    }
    public static void postOrderIterative1(TreeNode root){
        //Using two Stacks
        Stack<TreeNode>st1=new Stack<>();
        Stack<TreeNode>st2=new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode ex=st1.pop();
            st2.push(ex);
            if(ex.left!=null){
                st1.push(ex.left);
            }
            if(ex.right!=null){
                st1.push(ex.right);
            }
        }
        while(!st2.isEmpty()){
            System.out.print(st2.pop().val+",");
        }
    }
    public static void postOrderIterative2(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        while (!stack.isEmpty() || current != null) {
            // Go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode peekNode = stack.peek();

            // If right child exists and traversing node from left child, then move right
            if (peekNode.right != null && lastVisited != peekNode.right) {
                current = peekNode.right;
            } else {
                // If there is no right child or it has already been processed
                System.out.print(peekNode.val + ",");
                lastVisited = stack.pop();
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
        System.out.println("Recursive:");
        postOrderRecursive(root);
        System.out.println("\nIterative Using 2 Stacks:");
        postOrderIterative1(root);
        System.out.println("\nIterative Using 1 Stacks:");
        postOrderIterative2(root);
    }
}
