package Doubly_LinkedList;
class Node{
    Node prev;
    int Data;
    Node next;

    Node(int val){
        this.prev=null;
        this.Data=val;
        this.next=null;
    }
}
class DoublyLinked{
    Node Head=null;
    Node Tail=null;


    public int size() {
        Node temp = Head;
        int count=0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public void InsertAtHead(int val){
        Node newNode=new Node(val);
        if(Head==null){
            Head=Tail=newNode;
        }else{
           newNode.next=Head;
           Head.prev=newNode;
           newNode.prev=null;
           Head=newNode;
        }
    }
    public void InsertAtEnd(int val){
        Node temp=Head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newNode=new Node(val);
        temp.next=newNode;
        newNode.prev=temp;
        newNode.next=null;
    }
    public void InsertAtK(int val,int pos){

        if(pos<0||pos>size()){
            System.out.println("Invalid Index");
        }else if(pos<1){
            InsertAtHead(val);
        }else if(pos==size()){
            InsertAtEnd(val);
        }
        else{
            Node newNode=new Node(val);
             if(Head==null){
                Head=Tail=newNode;
            }
            Node temp=Head;
            int currPos=0;
            while(currPos!=pos-1&&temp!=null){
                temp=temp.next;
                currPos++;
            }
            if(temp==null){
                System.out.println("Invalid Index");
                return;
            }

            newNode.next=temp.next;
            temp.next=newNode;
            newNode.prev=temp;
        }

    }
    public void DeleteAtHead(){
        if(Head==null){
            Head=Tail=null;
        }else{
            Head=Head.next;
            Head.prev=null;
        }
    }
    public void DeleteAtEnd(){
        if(Head==null){
            Head=Tail=null;
        }
        Node temp=Head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next.prev=null;
        temp.next=null;

    }
    public void DeleteAtK(int pos){
        if(pos<0||pos>size()){
            System.out.println("Invalid Index");
        }else if(pos<1){
            DeleteAtHead();
        }else if(pos==size()){
            DeleteAtEnd();
        }else{
            Node temp=Head;
            int currPos=0;
            while(currPos!=pos-1){
                currPos++;
                temp=temp.next;
            }
           temp.next.next.prev=temp;
            temp.next=temp.next.next;
        }
    }
    public void DisplayList(){
        Node temp=Head;
        System.out.print("Head<->");
        while(temp!=null){

            System.out.print(temp.Data+"<->");
            temp=temp.next;
        }
        System.out.print("Tail");
    }
    public void DisplayFromRandomNode(Node Random){
        Node temp=Random;
        while(temp.prev!=null){
            temp=temp.prev;
        }
//After this point temp will point at Head of the list Because In Doubly Linked list the prev pointer of Head Node points to null.
        System.out.print("Head<->");
        while(temp!=null){

            System.out.print(temp.Data+"<->");
            temp=temp.next;
        }
        System.out.print("Tail");

    }
}
public class Basics {
    public static void main(String[]args){
        DoublyLinked dll=new DoublyLinked();
        for(int i=0;i<10;i++){
            dll.InsertAtHead(i);



        }
        System.out.println();
        dll.DisplayList();

        dll.InsertAtEnd(34);
        System.out.println();
        dll.DisplayList();
//
//        dll.InsertAtK(4,0);
//        System.out.println();
//        dll.DisplayList();
//
//        dll.DeleteAtHead();
//        System.out.println();
//        dll.DisplayList();
//
//        dll.DeleteAtEnd();
//        System.out.println();
//        dll.DisplayList();
//
//        dll.DeleteAtK(5);
//        System.out.println();
//        dll.DisplayList();
        System.out.println();

        dll.DisplayFromRandomNode(dll.Head.next.next.next.next);




    }
}
