While curr is not null:
Set next to the next node of curr.
Set curr's next pointer to prev.
Set prev to curr.
Set curr to next.
The head of the reversed linked list is now prev.
```java

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode currNode=head;
        ListNode prev=null;

        while(currNode!=null){
            ListNode nextNode=currNode.next;
            currNode.next=prev;
            prev=currNode;
            currNode=nextNode;
        }

        return prev;
    }
}
```
