```java
class Solution {
    public ListNode partition(ListNode head, int x) {
        //We will maintain 2 lists with small and larger lists
        ListNode Large=new ListNode(-1);
        ListNode Small=new ListNode(-1);

        //Pointers for large and small lists
        ListNode largeP=Large;
        ListNode smallP=Small;

        ListNode temp=head;

        while(temp!=null){
            if(temp.val>=x){
                ListNode newNode=new ListNode(temp.val);
                largeP.next=newNode;
                largeP=largeP.next;
            }else{
                ListNode newNode=new ListNode(temp.val);
                smallP.next=newNode;
                smallP=smallP.next;
            }

            temp=temp.next;
        }

        //merging 2 lists with small list first and large list 2nd...
        smallP.next=Large.next;
        largeP.next=null;

        return Small.next;
    }
}
```
