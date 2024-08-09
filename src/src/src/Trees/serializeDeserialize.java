package Trees;

import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class serializeDeserialize {
    public static void enCode(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return ;
        }
        sb.append(root.val).append(",");
        enCode(root.left,sb);
        enCode(root.right,sb);
    }
    // Encodes a tree to a single string.


    public static String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        enCode(root,sb);
        return sb.toString();
    }

    public static TreeNode deCode(Queue<String>queue){
        String nodeVal=queue.poll();
        if(nodeVal.equals("null")) return null;
        TreeNode root=new TreeNode(Integer.parseInt(nodeVal));
        root.left=deCode(queue);
        root.right=deCode(queue);
        return root;
    }
    public static TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String []str=data.split(",");
        Queue<String>queue=new LinkedList<>(Arrays.asList(str));
      TreeNode root=deCode(queue);
       return root;

    }
    public static void display(TreeNode root){
        if(root==null){
            return;
        } System.out.print(root.val+",");
        display(root.left);

        display(root.right);
    }
    public static void main(String[]args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
//        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        display(root);
        System.out.println();
        String string=serialize(root);
        System.out.println(string);

        TreeNode node=deserialize(string);
        display(node);
        char ch=(char)(0+97);
        System.out.println(ch);

    }
}
