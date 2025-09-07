```java
class Solution {
    //Two Pointer Theorem
    public ListNode middleNode(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null ){//Only Check fast and fast.next for null
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
}
```
