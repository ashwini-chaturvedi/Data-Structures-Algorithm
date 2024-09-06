--------------------------------------------->Approach:1<-------------------------------------------------------
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

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}
--------------------------------------------->Approach:2<-------------------------------------------------------
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        ListNode dummy=new ListNode(0,head);
        ListNode temp=head;
        ListNode prev=dummy;

        while(temp!=null){
            if(set.contains(temp.val)){
                temp=temp.next;
                prev.next=temp;
            }else{
                prev=temp;
                temp=temp.next;
            }
        }
        return dummy.next;
    }
}
