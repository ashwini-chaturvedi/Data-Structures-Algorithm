package Stacks;
class Node{
    int data;
    Node next;
    Node(int val){
        this.data=val;
        this.next=null;
    }
}
class stacks{
    Node head=null;
     int currSize;

   boolean isEmpty(){
       return head==null;
   }
   void push(int val){
       Node newNode=new Node(val);
       newNode.next=head;
       head=newNode;
       this.currSize++;
   }
   int pop(){
       if(isEmpty()){
           System.out.println("Stack UnderFlow");
           return Integer.MIN_VALUE;
       }
       int popVal=head.data;
       head=head.next;
       currSize--;
       return popVal;
   }
   int peek(){
       if(isEmpty()){
           System.out.println("Stack UnderFlow");
           return Integer.MIN_VALUE;
       }
       return head.data;
   }
   void display(){
       Node temp=head;
       while(temp!=null){
           System.out.print(temp.data+"->");
           temp=temp.next;
       }
   }


}
public class LinkedList_Implementation {
    public static void main(String[]args){
        stacks st=new stacks();
        System.out.println("\nEmpty:"+st.isEmpty());
        for(int i=1;i<1000000;i++){
            st.push(i);
        }
        st.display();
        System.out.println("\nEmpty:"+st.isEmpty());

        System.out.println("\nSize:"+st.currSize);


        System.out.println("\nTop Value:"+st.peek());
        System.out.println("\nPopped value:"+st.pop());

        System.out.println("\nTop Value:"+st.peek());
        System.out.println("\nPopped value:"+st.pop());

        System.out.println("\nTop Value:"+st.peek());
        System.out.println("\nPopped value:"+st.pop());

        System.out.println("\nTop Value:"+st.peek());
        System.out.println("\nPopped value:"+st.pop());

        System.out.println("\nTop Value:"+st.peek());
        System.out.println("\nPopped value:"+st.pop());

        System.out.println("\nEmpty:"+st.isEmpty());



    }
}
