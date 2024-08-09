package Trees;

public class diameterOfBinaryTree {
    public static int solve(TreeNode root,int[]count){
        if(root==null){
            return 0;
        }
        int left=solve(root.left,count);
        int right=solve(root.right,count);
        int sum=left+right;
        count[0]=Math.max(count[0],sum);
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
        int[]count={0};
        int height=solve(root,count);
        System.out.println(count[0]);
    }
}
