package Recursion.Recursion;

class ListNode{
    int val;
    ListNode next;
    ListNode(int data){
        this.val=data;
        this.next=null;
    }

}
class ll{
    ListNode head=null;
    ListNode tail=null;
    public void insert(int val){
        ListNode newNode=new ListNode(val);
        if(head==null){
            head=tail=newNode;
        }else{
            tail.next=newNode;
            newNode.next=null;
            tail=newNode;
        }
    }

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



}


public class palindromeLinkedList {
    public static void displa(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }

    }
//    public static ListNode solve(ListNode l1,ListNode l2,ListNode head,ListNode tail,int carry){
//        if (l1 == null && l2 == null) {
//            if (carry > 0) {
//                tail.next = new ListNode(carry);
//            }
//            return head;
//        }
//        int val1=l1!=null?l1.val:0;
//        int val2=l2!=null?l2.val:0;
//        int sum=val1+val2+carry;
//        ListNode newNode=new ListNode(sum%10);
//
//        if(head==null){
//            head=tail=newNode;
//        }else{
//            tail.next=newNode;
//            tail=newNode;
//
//        }
//        carry=sum/10;
//        ListNode next1=l1!=null?l1.next:null;
//        ListNode next2=l2!=null?l2.next:null;
//
//        return solve(next1,next2,head,tail,carry);
//    }
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head=null;
//        ListNode tail=null;
//        int carry=0;
//
//        return solve(l1,l2,head,tail,carry);
//    }
public static void solve(ListNode head,ListNode newHead,int carry){
    if(head==null){
        return;
    }
    solve(head.next,newHead,carry);
    int sum=2*head.val+carry;
    ListNode newNode=new ListNode(sum%10);
    newNode.next=newHead;
    newHead=newNode;
    carry=sum/10;
    return;
}
    public static ListNode doubleIt(ListNode head) {
        ListNode newHead=null;
        int carry=0;
        solve(head,newHead,carry);
        return newHead;
    }
    public static void main(String[] args) {
//        ll l1=new ll();
//        l1.insert(9);
//        l1.insert(9);
//        l1.insert(9);
//        l1.insert(9);
//        l1.insert(9);
//        l1.insert(9);
//        l1.insert(9);


        ll l2=new ll();
        l2.insert(1);
        l2.insert(8);
        l2.insert(9);


//        ListNode temp=addTwoNumbers(l1.head,l2.head);
//        displa(temp);
        ListNode ne=doubleIt(l2.head);
        displa(ne);





    }
}
