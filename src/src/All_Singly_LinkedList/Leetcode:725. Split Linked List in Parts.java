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
// Time Complexity:O(N)
class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {// Finding the size of the list
            temp = temp.next;
            size++;
        }

        ListNode[] res = new ListNode[k];
        int rem = size % k;
        int base = size / k;

        for (int i = 0; i < k; i++) {
            res[i] = head; // store the list from head into the res

          // Handling the Remainder
            int time = base + (rem > 0 ? 1 : 0);
            if (rem > 0) rem--;
          
            for (int j = 0; j < time - 1; j++) {
                if (head != null) {
                    head = head.next;  // collect the list 
                }
            }

            if (head != null) { // moving the head to next part while securing that we don't lost the remaining list
                ListNode nextPart = head.next;
                head.next = null;
                head = nextPart;
            }

           
        }
        return res;
    }
}
