package Trees;

import java.util.ArrayList;
import java.util.List;

public class rightSideView {
    public static void solveL(TreeNode root, int level, List<Integer>list){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.val);
        }
        solveL(root.left,level+1,list);
        solveL(root.right,level+1,list);

    }
    public static void solve(TreeNode root, int level, List<Integer>list){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.val);
        }

        solve(root.right,level+1,list);
        solve(root.left,level+1,list);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.left.right.left=new TreeNode(0);
        List<Integer>list=new ArrayList<>();
//        solve(root,0,list);
//        System.out.println(list);
        solveL(root,0,list);
        System.out.println(list);
        StringBuilder sb=new StringBuilder();



    }
}
