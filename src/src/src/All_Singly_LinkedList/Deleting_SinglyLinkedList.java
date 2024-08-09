package All_Singly_LinkedList;

class Node{
    int data;
    Node next;
    Node(int val){
        this.data=val;
        this.next=null;
    }
}
class Singly{
    Node Head=null;
    Node Tail=null;

    void InsertAtEnd(int val) {
        Node temp = new Node(val);
        if (Head == null) {
            Head = temp;
        } else {
            Tail.next = temp;
        }
        Tail = temp;
    }

    public void InsertAtHead(int val) {
        Node newHead = new Node(val);
        if (Head == null) {
            Head = Tail = newHead;
        } else {
            newHead.next = Head;
            Head = newHead;
        }
    }

    public void InsertAtK(int val, int pos) {
        Node newNode = new Node(val);
        if(pos==size()){
            InsertAtEnd(val);
        }else if (pos == 0) {
            InsertAtHead(val);
        }else if(pos<0||pos>size()){
            System.out.println("Invalid Index");
        }else {
            Node temp = Head;
            int currPos = 1; // Start from position 1
            while (currPos != pos ) {
                temp = temp.next;
                currPos++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    } public int size() {
        Node temp = Head;
        int count=0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void displayList() {
        Node temp = Head;
        System.out.print("Head->");
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("Tail");
    }
    public  void DeleteAtHead(){
        if(Head==null){
            return;
        }else{
            Head=Head.next;

        }
    }
    public void DeleteAtEnd(){
        Node temp=Head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;

    }
    public void DeleteAtK(int pos){
        if(pos==size()){
            DeleteAtEnd();
        }else if(pos==1){
            DeleteAtHead();
        }else if(pos<0||pos>size()){
            System.out.println("Invalid Index");
        }else{
            Node temp=Head;
            int currPos=0;
            while(currPos!=pos-1){
                temp=temp.next;
                currPos++;
            }
            temp.next=temp.next.next;

        }
    }
    public void DeleteFromEnd(int pos){
        Node First=Head;
        Node Second=Head;
        for(int i=1;i<=pos;i++){
            First=First.next;
        }
        if(First==null){
            Head=Head.next;

        }else {
            while (First.next != null) {
                First = First.next;
                Second = Second.next;
            }
            Second.next = Second.next.next;
        }


    }
}
public class Deleting_SinglyLinkedList {
    public static void main(String[]args){
        Singly sll = new Singly();
        for (int i = 0; i < 10; i++) {
            sll.InsertAtHead(i+1);
        }
        sll.displayList();
        System.out.println();
        sll.DeleteAtHead();
        sll.displayList();
        System.out.println();
        sll.DeleteAtEnd();
        sll.displayList();
        System.out.println();
        sll.DeleteAtK(5);
        sll.displayList();
        System.out.println();
        sll.DeleteFromEnd(7);
        sll.displayList();




    }
}
