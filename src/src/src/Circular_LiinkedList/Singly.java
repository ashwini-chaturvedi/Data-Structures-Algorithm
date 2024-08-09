package Circular_LiinkedList;

class node1{
    int Data;
    node1 next;
    node1(int val){
        this.Data=val;
        this.next=null;
    }
}
class SinglyCircular{
    node1 head=null;
    node1 tail=null;

    public void InsertAtHead(int val){
        node1 newNode=new node1(val);
        if(head==null){
            head=tail=newNode;
        }else{
            newNode.next=head;
            tail.next=newNode;
            head=newNode;
        }

    }
    public void InsertAtEnd(int val){
        node1 newNode=new node1(val);
        if(head==null){
            head=tail=newNode;
        }else{
            newNode.next=head;
            tail.next=newNode;
            tail=newNode;
        }
    }
    public void displayList(){
        node1  temp=head;
        System.out.print("Head<->");
        do{
            System.out.print(temp.Data+"<->");
            temp=temp.next;
        }while(temp!=head);
        System.out.print("Tail");
    }
}
public class Singly {
    public static void main(String[]args){
        SinglyCircular scll=new SinglyCircular();
        for(int i=0;i<10;i++){
            scll.InsertAtHead(i);
        }
        scll.displayList();
        System.out.println();
        scll.InsertAtEnd(89);
        scll.displayList();
        System.out.println();
        scll.InsertAtHead(56);
        scll.displayList();

    }
}
