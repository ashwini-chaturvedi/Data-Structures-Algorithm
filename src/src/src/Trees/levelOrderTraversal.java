package Trees;

import java.util.*;


public class levelOrderTraversal {

    public static void zigZagTraversal(TreeNode root,List<List<Integer>>list,int currLevel){
        if(root==null){
            return;
        }
        if(list.size()<=currLevel){
            list.add(new ArrayList<>());
        }
        if(currLevel%2==0){//if the currLevel is even we will add the value simply
            list.get(currLevel).add(root.val);
        }else{
            list.get(currLevel).add(0,root.val);//we will add elements at 0th index one by one which will simply add the
            //elements in reverse Order...
        }
        zigZagTraversal(root.left,list,currLevel+1);
        zigZagTraversal(root.right,list,currLevel+1);
    }
    public  static void levelOrderRecursive(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        // Ensure the result list has enough levels
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        // Add the current node's value to the corresponding level list
            result.get(level).add(root.val);

        // Recursively process the left and right subtrees
         levelOrderRecursive(root.left, level + 1, result);

        levelOrderRecursive(root.right, level + 1, result);

    }
    public static void flattenLevelOrder(TreeNode root,Queue<TreeNode>queue,List<Integer>list){
        if(queue.isEmpty()){
            return;
        }
        if(root==null){
            return;
        }
        TreeNode node=queue.poll();

      if(root.left!=null) {queue.add(root.left);}
      if(root.right!=null) {queue.add(root.right);}

        list.add(node.val);
        flattenLevelOrder(root.left,queue,list);
        flattenLevelOrder(root.right,queue,list);


    }

    public static void levelOrderIterative(TreeNode root,Queue<TreeNode>queue,List<List<Integer>>list){
        if(root==null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int level=queue.size();
            List<Integer>subList=new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode nextNode=queue.poll();
                if(nextNode.left!=null){
                    queue.add(nextNode.left);
                }
                if(nextNode.right!=null){
                    queue.add(nextNode.right);
                }
                subList.add(nextNode.val);
            }
            list.add(subList);
        }

    }
    public static void main(String[]args){
        TreeNode root=new TreeNode(1);
         root.left=new TreeNode(2);
         root.right=new TreeNode(3);
         root.left.left=new TreeNode(4);
         root.left.right=new TreeNode(5);
         root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
         Queue<TreeNode> queue=new LinkedList<>();
         queue.add(root);

        //Recursive Approach=>
//         List<Integer>list=new ArrayList<>();
//        flattenLevelOrder(root,queue,list);
//        System.out.println(list);
        List<List<Integer>>ans=new ArrayList<>();
        levelOrderRecursive(root,0,ans);
        System.out.println(ans);

        //Iterative Approach=>
        List<List<Integer>>res=new ArrayList<>();
        Queue<TreeNode> que=new LinkedList<>();
        levelOrderIterative(root,que,res);
        System.out.println(res);
        //Zig-Zag Traversal of Tree...
        List<List<Integer>>list=new ArrayList<>();
        zigZagTraversal(root,list,0);
        System.out.println(list);


    }
}
