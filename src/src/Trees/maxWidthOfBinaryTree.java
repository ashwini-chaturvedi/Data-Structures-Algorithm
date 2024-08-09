package Trees;

import java.util.*;

class duo{
    TreeNode node;
    int idx;
    duo(TreeNode node,int i){
        this.node=node;
        this.idx=i;
    }
}
public class maxWidthOfBinaryTree {
    public static int maxWidth(TreeNode root){

        if(root==null) return 0;
        Queue<duo> queue=new LinkedList<>();
        int maxiWidth=0;
        queue.add(new duo(root,0));
        while(!queue.isEmpty()){
            int size= queue.size();//size of the current queue
            int minVal=queue.peek().idx;//min value at that level will be at the pair's element which is at front in queue
            int min=0;//min value at a level
            int max=0;//max value at a level
            for(int i=0;i<size;i++){//Traversing till the size of the queue
                int currIdx=queue.peek().idx-minVal;//for handling overflow in skewed tree we will reinitialize the index at
                //Starting of each level
                TreeNode node=queue.peek().node;//we will take out the node at the front to traverse it
                queue.remove();
                if(i==0) min=currIdx;//if it is the first node of the level it will be minimum at that level
                if(i==size-1) max=currIdx;//if it is the last node at that level it will be max at that level
                if(node.left!=null){
                    queue.add(new duo(node.left,currIdx*2+1));
                }
                if(node.right!=null){
                    queue.add(new duo(node.right,currIdx*2+2));
                }

            }
            maxiWidth=Math.max(maxiWidth,(max-min+1));
        }
        return maxiWidth;
    }
    public static void treeSum(TreeNode root,int[]sum){
        if(root==null){
            return;
        }
        sum[0]+=root.val;
        treeSum(root.left,sum);
        treeSum(root.right,sum);
    }
    public static void main(String[]args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        System.out.println(maxWidth(root));
        int[]sum={0};
        treeSum(root,sum);
        System.out.println(sum[0]);

    }
}
