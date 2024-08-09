package Queue;
class Node{
    int val;
    Node next;
    Node(int data){
        this.val=data;
        this.next=null;
    }
}
class queueL{
      Node head=null;
      Node tail=null;
      public boolean isEmpty(){
          return head==null;
      }
      public void enqueue(int val){
          Node newNode=new Node(val);
            if(head==null){
                head=tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }

      }
      public int dequeue(){
          if(isEmpty()){
              System.out.println("Queue is Empty...");
              return -1;
          }else{
              int removedVal=head.val;
              head=head.next;
              return removedVal;
          }
      }
      public int peek(){
          return head.val;
      }
      public void Display(){
          Node temp=head;
          while(temp!=null){
              System.out.print(temp.val+",");
              temp=temp.next;
          }

      }
}
public class LinkedListImplementation {
    public static void main(String[]args){
        queueL q=new queueL();

        for(int i=0;i<10;i++){System.out.println(q.isEmpty());
            q.enqueue(i);
        }
        q.Display();
        System.out.println(q.isEmpty());
        System.out.println(q.dequeue());
        q.Display();
//        System.out.println(q.remove());
//        System.out.println(q.remove());
//        System.out.println(q.remove());
//        System.out.println(q.remove());
//        System.out.println(q.peek());
    }
}
