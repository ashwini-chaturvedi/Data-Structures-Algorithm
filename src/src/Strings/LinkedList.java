package Strings;

class Node{
    String Data;
    Node next;

    Node(String str){
        this.Data=str;
        this.next=null;
    }
}
class sll{
    Node Head=null;
    Node Tail=null;
    public void InsertAtHead(String val){
        Node newNode=new Node(val);
        if(Head==null){
            Head=Tail=newNode;
        }else{
            newNode.next=Head;
            Head=newNode;
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
}
public class LinkedList {
    public static void main(String[]args){
        sll s=new sll();






        s.InsertAtHead("of String");
        s.InsertAtHead("Implementation");
        s.InsertAtHead("List");
        s.InsertAtHead("Linked");
        s.InsertAtHead("is");
        s.InsertAtHead("This");
        s.InsertAtHead("Hii");
        s.DisplayList();



    }
}
