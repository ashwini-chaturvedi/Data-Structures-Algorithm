```java
class Solution {
    public void treeSum(TreeNode root,long[]sum){
        if(root==null){
            return;
        }
        sum[0]+=root.val;
        treeSum(root.left,sum);
        treeSum(root.right,sum);
    }
    public long maxSum(TreeNode root,long[]sum,long[]max){
        if(root==null){
            return 0;
        }
       
        long left=maxSum(root.left,sum,max);
        long right=maxSum(root.right,sum,max);
        long subTreeSum=root.val+left+right;

        long remainingSubTreeSum=sum[0]-subTreeSum;

        max[0]=Math.max(max[0],subTreeSum*remainingSubTreeSum);
        return subTreeSum;
    }
    public int maxProduct(TreeNode root) {
        long[]sum={0};
        treeSum(root,sum);

        long []max={0};
        long a=maxSum(root,sum,max);
        return (int)(max[0]%1000000007);
    }
}
```
