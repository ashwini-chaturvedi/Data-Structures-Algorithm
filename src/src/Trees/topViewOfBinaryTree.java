package Trees;

import java.util.*;

 class pair{
    TreeNode node;
    int horiDist;
    pair(TreeNode node,int x){
        this.node=node;
        this.horiDist=x;
    }
}

public class topViewOfBinaryTree {
    public static void fromTop(TreeNode root,int hd,int level,Map<Integer,pair>map){
        if(root==null){
            return ;
        }

        fromTop(root.left,hd-1,level+1,map);
        if(!map.containsKey(hd)||level<map.get(hd).horiDist){
            map.put(hd,new pair(root,level));
        }
        fromTop(root.right,hd+1,level+1,map);
    }
    public static List<Integer>topView(TreeNode root){
        List<Integer>list=new ArrayList<>();
        Map<Integer,pair>map=new TreeMap<>();
        int x=0;
        int y=0;
        fromTop(root,x,y,map);

        for(var e:map.entrySet()){
            list.add(e.getValue().node.val);//adding the value into the list
        }
        return list;
    }
    public static void main(String[]args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        System.out.println(topView(root));

    }
}
