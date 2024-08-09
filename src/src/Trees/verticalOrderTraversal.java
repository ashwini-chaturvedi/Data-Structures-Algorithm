package Trees;

import java.util.*;

class tuple{
    TreeNode root;
    int x;
    int y;
    tuple(TreeNode node,int row,int col){
        this.root=node;
        this.x=row;
        this.y=col;
    }
}
public class verticalOrderTraversal {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>map=new TreeMap<>();
        Queue<tuple> Q=new LinkedList<>();
        Q.add(new tuple(root,0,0));//adding the Node at 0,0 in the queue
        while(!Q.isEmpty()){
            tuple temp=Q.remove();
            TreeNode node=temp.root;
            int x=temp.x;
            int y=temp.y;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).add(node.val);

            if(node.left!=null){
                Q.add(new tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                Q.add(new tuple(node.right,x+1,y+1));
            }
        }
        List<List<Integer>>list=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>>ref:map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer>q:ref.values()){
                while(!q.isEmpty()){
                    list.get(list.size()-1).add(q.remove());
                }
            }
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
        System.out.println(verticalTraversal(root));
    }
}
