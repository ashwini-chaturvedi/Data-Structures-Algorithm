Given a binary tree with the following rules:

root.val == 0
For any treeNode:
If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

Implement the FindElements class:

FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
bool find(int target) Returns true if the target value exists in the recovered binary tree.

![img](https://assets.leetcode.com/uploads/2019/11/06/untitled-diagram-4.jpg)
Input
["FindElements","find","find","find"]
[[[-1,-1,-1,-1,-1]],[1],[3],[5]]

Output
[null,true,true,false]

Explanation

FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
findElements.find(1); // return True
findElements.find(3); // return True
findElements.find(5); // return False

```java
class FindElements {
    //Correct the Tree
    //While Correcting the Tree store the node values in a Set which is Globally Accessible
    //then in find function just check wheather Element occur in set or not
    Set<Integer>set;

    public void doDfs(TreeNode root,int val,Set<Integer>set){
        if(root==null) return;

        root.val=val;
        set.add(val);//Stor the values

        if(root.left!=null) doDfs(root.left,(2*val)+1,set);
        if(root.right!=null) doDfs(root.right,(2*val)+2,set);
    }
    

    public FindElements(TreeNode root) {
        set=new HashSet<>();
        doDfs(root,0,set);
        
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}
```
