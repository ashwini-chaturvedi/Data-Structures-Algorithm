package Trees;

import java.util.ArrayList;
import java.util.List;

public class ex {
    public static void inOrder(TreeNode root,List<Integer>list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    public static void findPreSuc(TreeNode root, TreeNode[] pre, TreeNode[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        List<Integer>list=new ArrayList<>();
        inOrder(root,list);
        pre[0]=null;
        suc[0]=null;
        for(int i=0;i<list.size();i++){
            if(list.get(i)<key){
                pre[0]=new TreeNode(list.get(i));
            }else if(list.get(i)>key){
                if(suc[0]==null){
                    suc[0]=new TreeNode(list.get(i));
                }
            }else{
                if(i>0){
                    pre[0]=new TreeNode(list.get(i-1));
                }
                if(i<list.size()-1){
                    suc[0]=new TreeNode(list.get(i+1));
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(2);
        root.right=new TreeNode(11);

        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(3);
        root.left.right.left.right=new TreeNode(4);
        root.left.right.right=new TreeNode(6);
        TreeNode[] pre=new TreeNode[1];
        TreeNode[] suc=new TreeNode[1];
        findPreSuc(root,pre,suc,8);
        System.out.print(pre[0].val+",");
        System.out.print(suc[0].val);

    }
}
