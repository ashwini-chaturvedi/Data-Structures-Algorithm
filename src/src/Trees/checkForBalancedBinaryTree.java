package Trees;

public class checkForBalancedBinaryTree {
    public static int check(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=check(root.left);
        if(left==-1){
            return -1;
        }
        int right=check(root.right);
        if(right==-1){
            return -1;
        }
        //checking if the absolute difference of the left and right half is greater then 1
        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
    public static void main(String[]args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.right.right.left=new TreeNode(7);
        root.right.right.left.right=new TreeNode(7);
        if(check(root)==-1){
            System.out.println(false);;
        }else{
            System.out.println(true);
        }
    }
}
