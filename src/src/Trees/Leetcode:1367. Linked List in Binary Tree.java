/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Time Complexity:O(N*M)
class Solution {
    public boolean solve(TreeNode root, ListNode head) {

        if (head == null)
            return true; // successfully traversed all the nodes of LinkedList.
        if (root == null)
            return false; // Tree Path Ended but the List didn't matched

        if (root.val == head.val) { // if the values of the node matches in both then try checking on the left and
           // right side of the node for the value on the next in list
            return solve(root.left, head.next) || solve(root.right, head.next);

        }
        return false;

    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        // Try matching from the current root node or any of its children
        return solve(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
