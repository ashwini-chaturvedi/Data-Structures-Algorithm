package Queue.CircularQueue;
class Node{
    int val;
    Node next;

    Node(int data){
        this.val=data;
    }
}
class queue{
    Node Front=null;
    Node Rear=Front;

    public boolean isEmpty(){
        return Front==null;
    }
    public void add(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            Front=Rear=newNode;
        }else{
            Rear.next=newNode;
            Rear=newNode;
        }
        Rear.next=Front;//circular Queue

    }
    public int remove()throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removedVal=Front.val;
        Front=Front.next;
        Rear=Front;
        return removedVal;
    }
    public int peek()throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return Front.val;
    }
    public void display(){
        Node temp=Front;
        System.out.print("Front->");
        do{
            System.out.print(temp.val+"->");
            temp=temp.next;
        }while(temp!=Front);
        System.out.print("Rear");
        System.out.println();
    }
}
public class LinkedListImplementation {
    public static void main(String[]args)throws Exception{
        queue cq=new queue();
        for(int i=1;i<=5;i++){
            cq.add(i);
        }
        cq.display();
        cq.remove();
        cq.remove();
        cq.add(909);
        cq.display();
    }
}
