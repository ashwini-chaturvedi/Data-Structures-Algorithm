package Circular_LiinkedList;

class Node{
    Node prev;
    int data;
    Node next;

    Node(int val){
        prev=null;
        data=val;
        next=null;
    }
}
class CircularLinkedList{
    Node Head=null;
    Node Tail=null;

    public void InsertAtHead(int val){
        Node newNode=new Node(val);
        if(Head==null) {
            Head = Tail = newNode;
        }else{
            newNode.next=Head;
            Head.prev=newNode;
            newNode.prev=Tail;
            Tail.next=newNode;
            Head=newNode;


        }
    }
    public void InsertAtEnd(int val){
        Node newNode=new Node(val);
        Node temp=Head;
        while(temp.next!=Head) {
            temp = temp.next;
        }
        temp.next=newNode;
        newNode.prev=temp;
        newNode.next=Head;
        Head.prev=newNode;
        Tail=newNode;//atlast Tail will point to the newNode.
    }
    public void InsertAtK(int val,int pos){
        Node newNode=new Node(val);
        Node temp=Head;
        int currPos=1;
        while(currPos!=pos-1){
            temp=temp.next;
            currPos++;
        }
        newNode.next=temp.next;
        temp.next.prev=newNode;
        temp.next=newNode;
        newNode.prev=temp;


    }
    public void displayList(){
        Node temp=Head;
        System.out.print("Head<->");
        do{
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }while(temp!=Head);
        System.out.print("Tail");
    }

}
public class Doubly {
    public static void main(String[]args){
        CircularLinkedList cll=new CircularLinkedList();
        for(int i=0;i<10;i++){
            cll.InsertAtHead(i);

        }
        cll.displayList();
        System.out.println();
        cll.InsertAtEnd(34);
        cll.displayList();
        System.out.println();
        cll.InsertAtK(84,5);
        cll.displayList();
        System.out.println();


    }
}
