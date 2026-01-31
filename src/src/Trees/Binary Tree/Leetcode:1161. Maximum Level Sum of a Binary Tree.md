```java


 //DO level order and check sum at each level and take a counter of level 
class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxVal=root.val;
        int level=1;
        int currLevel=1;

        Queue<TreeNode>que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                sum+=node.val;
                if(node.left!=null){                    
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
            }
            if(sum>maxVal){
                level=currLevel;
                maxVal=sum;
            }
            currLevel++;

        }
        return level;
    }
}
```
