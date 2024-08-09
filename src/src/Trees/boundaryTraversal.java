package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class boundaryTraversal {
    //Iterative Approach...
    public static boolean isLeafNode(TreeNode root){
        return root.left==null&&root.right==null;
    }
    public static void addtoleft(TreeNode root,List<Integer>list){
       TreeNode currNode=root.left;
       while(currNode!=null){
           if(isLeafNode(currNode)==false) list.add(currNode.val);//if the node is not a leaf node so add its value to the list
           if(currNode.left!=null) currNode=currNode.left;
           else currNode=currNode.right;
       }
    }
    public static void addtoRight(TreeNode root,List<Integer>list){
        TreeNode currNode=root.right;
        Stack<Integer>st=new Stack<>();
        while(currNode!=null){
            if(isLeafNode(currNode)==false) st.push(currNode.val);
            if(currNode.right!=null) currNode=currNode.right;
            else currNode=currNode.right;
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }

    }
    public static void addtoLeaf(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        if(isLeafNode(root)){
            list.add(root.val);
            return;
        }
        addtoLeaf(root.left,list);

        addtoLeaf(root.right,list);
    }
    public static List<Integer> IterativeboundaryTraverseAntiClockwise(TreeNode root){
        List<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        if(isLeafNode(root)==false) list.add(root.val);
        addtoleft(root,list);
        addtoLeaf(root,list);
        addtoRight(root,list);

        return list;
    }


    //Recursive Approach...
    public  static boolean isLeaf(TreeNode root){
        return root.left==null&&root.right==null;
    }
    public static void addToLeft(TreeNode root,ArrayList<Integer>list){
        if(root==null){
            return;
        }
        if(!isLeaf(root)) list.add(root.val);
        if(root.left!=null){
            addToLeft(root.left,list);
        }else{
            addToLeft(root.right,list);
        }

    }
    public static void addToRight(TreeNode root,ArrayList<Integer>list){
        if(root==null){
            return;
        }

        if(root.right!=null){
            addToRight(root.right,list);
        }else{
            addToRight(root.left,list);
        }
        if(!isLeaf(root)){
            list.add(root.val);
        }
    }
    public static void addToLeaf(TreeNode root,ArrayList<Integer>list){
        if(root==null){
            return;
        }
        //Pre Order Traversal
        if(isLeaf(root)){
            list.add(root.val);
            return;
        }
        addToLeaf(root.left,list);

        addToLeaf(root.right,list);
    }
    public static List<Integer> RecursiveboundaryTraverseAntiClockwise(TreeNode root){
        ArrayList<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        if(isLeaf(root)==false) list.add(root.val);
        addToLeft(root.left,list);
        addToLeaf(root,list);
        addToRight(root.right,list);

        return list;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        System.out.println("Iterative:"+IterativeboundaryTraverseAntiClockwise(root));
        System.out.println("Recursive:"+RecursiveboundaryTraverseAntiClockwise(root));

    }
}
