package Trees;

import java.util.ArrayList;
import java.util.List;

public class rootToNodePath {
    public static void pathing(TreeNode root,int target,List<Integer>list){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.val==target){
            return;
        }
        pathing(root.left,target,list);
        pathing(root.right,target,list);
        if(list.get(list.size()-1)!=target){
            list.remove(list.get(list.size()-1));
        }
    }
    public static void path(TreeNode root,int target){
        List<Integer> list=new ArrayList<>();
        pathing(root,target,list);
        System.out.println(list);
    }
    public static void main(String[]args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(6);
        root.left.right.right=new TreeNode(7);
//        root.right.left=new TreeNode(6);
//        root.right.right=new TreeNode(7);
        int target=7;
        path(root,target);
    }
}
