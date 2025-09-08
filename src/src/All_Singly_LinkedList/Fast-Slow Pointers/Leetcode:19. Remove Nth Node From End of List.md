
  Initialize two pointers, p and q, to the head of the linked list.
  Advance the pointer q, n nodes ahead of the pointer p.
  Now, advance both pointers p and q one node at a time.
  When the pointer q reaches the end of the linked list, the pointer p will be at the nth node from the end.
```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prevHead = new ListNode(0, head);

        ListNode first = head;
        ListNode second = prevHead;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;//Removing

        return prevHead.next;
    }
}

```
