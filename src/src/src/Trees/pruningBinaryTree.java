package Trees;

import java.util.ArrayList;
import java.util.List;

public class pruningBinaryTree {
    public static boolean isLeaf(TreeNode root){
        return root.left==null&&root.right==null;
    }
    public static TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.val==0 && isLeaf(root)){
            return null;
        }
        return root;
    }
    public static void display(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+",");
        display(root.left);

        display(root.right);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(1);
        root.right=new TreeNode(0);
        root.left.left=new TreeNode(1);
        root.left.left.left=new TreeNode(0);
        root.left.right=new TreeNode(1);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(1);
        display(root);
        TreeNode node=pruneTree(root);
        System.out.println("After Pruning");
        display(node);

    }
}
