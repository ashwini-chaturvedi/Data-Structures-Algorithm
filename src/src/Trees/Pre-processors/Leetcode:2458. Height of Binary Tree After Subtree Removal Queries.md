# Time Complexity:O(N)
# Space Complexity:o(N)
# Approach:
## 1.We will find the Height of the Subtrees at every Node and will store the Maximum and Second Maximum Height at that level.This is called Pre-Proccessing
## 2.When ever a node is to be Deleted we will check if that node is Maximum height at that level if it is than we will apply the formula for newHeight after removal of subtree on that secondmaxLevel Height.

```java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   /*Approach:
   1.We will find the Height of the Subtrees at every Node and will store the Maximum and Second Maximum Height at that level.
   2.When ever a node is to be Deleted we will check if that node is Maximum height at that level if it is than we will apply the formula for newHeight after removal of subtree on that secondmaxLevel Height.
   */
    private int[] Level = new int[100001];//Stores the Level 
    private int[] Height = new int[100001];//Stores the Height
    private int[] levelMaxHt = new int[100001];//Stores the Maximum height at that Level
    private int[] levelSecondMaxHt = new int[100001];//Stores the Second Maximum height at that Level

    public int findHeight(TreeNode root, int currLevel) {
        if (root == null) return 0;

        Level[root.val] = currLevel;//Store the CurrLevel
        int left = findHeight(root.left, currLevel + 1);//Height of Left Subtree
        int right = findHeight(root.right, currLevel + 1);//Height of Right Subtree

        Height[root.val] = Math.max(left, right) + 1; //Main Height finding formula

        //Storing the Maximum and Second Maximum Heights at that Level
        if (levelMaxHt[currLevel] < Height[root.val]) {//if the Height at that node's value is greater than the height at that level so Update the Values
            levelSecondMaxHt[currLevel] = levelMaxHt[currLevel]; //Update the Second Maximum Height at currLevel
            levelMaxHt[currLevel] = Height[root.val]; //Update the Maximum Height at currLevel
        } else if (levelSecondMaxHt[currLevel] < Height[root.val]) {//Similar to above but for Second Maximum Level
            levelSecondMaxHt[currLevel] = Height[root.val]; //Update the Second Maximum Height at currLevel
        }
        return Height[root.val];
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        //Calculate the Actual Height and Store the Level of Each Node and maximum height at that Level also second maximum Height at that level.
        int currLevel = 0;
        findHeight(root, currLevel); //found the Height and Stored it accordingly for accessing them in O(1) time

        //Processing the Query
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int nodeToDelete = queries[i];
            int nodeLvl = Level[nodeToDelete];

            //Find the Maximum Heighted Node at that Level to store the answer
            int maxHt = levelMaxHt[nodeLvl] == Height[nodeToDelete] ? levelSecondMaxHt[nodeLvl] : levelMaxHt[nodeLvl]; //if the node to be deleted has the same height as the node having Maximum Height at that Level then the next MaxHt after Deletion will be the Second Maximum Height.

            //heigh_afterRemoval=node's Level + Maximum Height at that Level -1
            int newHeight = nodeLvl + maxHt - 1;
            result[i] = newHeight;
        }
        return result;
    }
}


```      
