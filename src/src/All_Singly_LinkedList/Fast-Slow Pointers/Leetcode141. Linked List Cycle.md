```java
public class Solution {
    //Fast-Slow Pointer Pattern to find circle, duplicate etc in Linked List. 
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;//Found the Loop 
        }
        return false;
    }
}
```
