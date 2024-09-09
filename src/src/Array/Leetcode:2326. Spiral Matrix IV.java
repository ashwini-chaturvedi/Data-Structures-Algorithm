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
class Solution {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        // Filling the Matrix with -1 so that if there would be any empty cell it would have -1 as default
        for (int[] mat : matrix) {
            Arrays.fill(mat, -1);
        }

        ListNode temp = head;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int total = m * n;
        int count = 0;

        //Spiral Matrix technique adding and pushing the values one by one
        while (count < total && temp != null) {
            for (int j = left; j <= right && count < total && temp != null; j++) {
                matrix[top][j] = temp.val;
                temp = temp.next;
                count++;
            }
            top = top + 1;
            for (int i = top; i <= bottom && count < total && temp != null; i++) {
                matrix[i][right] = temp.val;
                temp = temp.next;
                count++;
            }
            right = right - 1;
            for (int j = right; j >= left && count < total && temp != null; j--) {
                matrix[bottom][j] = temp.val;
                temp = temp.next;
                count++;
            }
            bottom = bottom - 1;
            for (int i = bottom; i >= top && count < total && temp != null; i--) {
                matrix[i][left] = temp.val;
                temp = temp.next;
                count++;
            }
            left = left + 1;
        }
        return matrix;
    }
}
