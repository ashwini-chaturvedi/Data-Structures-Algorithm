package Trees;

import java.util.ArrayList;
import java.util.List;

public class pathByPath {
    public static void solve(TreeNode root, int startValue,StringBuilder sb,boolean flag){
        if(root==null) return;

        if(root.val==startValue){
            return;
        }

        solve(root.left,startValue,sb,flag);
        sb.append('U');

    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        StringBuilder sb=new StringBuilder();
        solve(root,2,sb,false);
        System.out.println(sb);
        StringBuilder sb1=new StringBuilder();

        System.out.println(sb1);
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<8;i++){
            list.add(i);
        }
        System.out.println(list);

    }
}
