package Trees;

import java.util.ArrayList;
import java.util.List;

public class Pre_In_Post_InOne {
    public static void preInPostRecursive(TreeNode root,List<Integer>pre,List<Integer>in,List<Integer>post){
        if(root==null){
            return;
        }
        pre.add(root.val);
        preInPostRecursive(root.left,pre,in,post);
        in.add(root.val);
        preInPostRecursive(root.right,pre,in,post);
        post.add(root.val);

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        List<Integer>pre=new ArrayList<>();
        List<Integer>in=new ArrayList<>();
        List<Integer>post=new ArrayList<>();
        preInPostRecursive(root,pre,in,post);
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }
}
