package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ec {
    public static void DFS(TreeNode root,List<Integer>list){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
        }

        DFS(root.left,list);
        DFS(root.right,list);
    }
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        DFS(root1,list1);
        List<Integer>list2=new ArrayList<>();
        DFS(root2,list2);
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);
        if(list1.size()!=list2.size()){
            return false;
        }
        for(int i=0;i<list1.size();i++){
            if(!Objects.equals(list1.get(i), list2.get(i))){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        root1.left=new TreeNode(2);
        root1.right=new TreeNode(200);
        TreeNode root2=new TreeNode(1);
        root2.left=new TreeNode(2);
        root2.right=new TreeNode(200);

        System.out.println( leafSimilar(root1,root2));

    }
}
