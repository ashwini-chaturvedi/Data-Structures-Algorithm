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
//Time Complexity:O(N)
class Solution {

    public int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) return head;

        ListNode Prev = head;
        ListNode Next = head.next;

        while (Next != null) {
            int gcd = GCD(Prev.val, Next.val);
            ListNode newNode = new ListNode(gcd);
            newNode.next = Next;
            Prev.next = newNode;
            Prev = Next;
            Next = Next.next;
        }
        return head;
    }
}
