package Trees;
class TreeNode{
    TreeNode left;
int val;
    TreeNode right;
    TreeNode(int data){
    this.val=data;
    this.left=null;
    this.right=null;
}

}
public class Basics {
    public static void main(String[]args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

    }
}
