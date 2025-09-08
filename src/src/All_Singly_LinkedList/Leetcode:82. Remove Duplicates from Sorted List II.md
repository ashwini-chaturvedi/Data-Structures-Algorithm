```java
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {

                while (head.next != null && head.val == head.next.val) {//moving while you get the non duplicate values...
                    head = head.next;
                }
                prev.next=head.next;//directly linking which makes the duplicate part gets deleted
            }else{
                prev = prev.next;//so that the last non duplicate node can be marked/pointed
            }
            head=head.next;            
        }

        return dummyHead.next;
    }
}

```
