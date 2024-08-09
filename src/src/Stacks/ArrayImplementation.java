package Stacks;
class stack{
 private final int[]arr=new int[10];
 private final int size=arr.length;
 private int topIdx=0;
 boolean isEmpty(){
     return topIdx==0;
 }
 boolean isFull(){
     return topIdx==size;
 }
 int size(){
     return topIdx;
 }
 void push(int val){
     if(this.topIdx==this.size){
         System.out.println("Stack OverFlow");
     }
     arr[topIdx]=val;
     topIdx++;
 }
 int  pop(){
     if(isEmpty()){
         System.out.println("Stack UnderFlow");
     }
     int popVal=arr[topIdx-1];
     arr[topIdx-1]=0;//again making the element at that index zero
     topIdx--;
     return popVal;
 }
 int peek(){
     if(isEmpty()){
         System.out.println("Stack is Empty");
         return -1;
     }
     return arr[topIdx-1];
 }
 void display(){
     for(int i=0;i<=topIdx-1;i++){
         System.out.print(arr[i]+" ");
     }
     System.out.println();
 }

}

public class ArrayImplementation {
    public static void main(String[]args){
        stack st=new stack();
        System.out.println("Empty:"+st.isEmpty());
        System.out.println("Full:"+st.isFull());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        System.out.println("Empty:"+st.isEmpty());
        System.out.println("Full:"+st.isFull());

        System.out.println("Top Element:"+st.peek());
        st.display();
        System.out.println("Size of the Stack"+st.size());
        System.out.println("Pop Element:"+st.pop());

        System.out.println("Top Element:"+st.peek());
        st.display();
        System.out.println("Size of the Stack"+st.size());
        System.out.println("Pop Element:"+st.pop());

        System.out.println("Top Element:"+st.peek());
        st.display();
        System.out.println("Size of the Stack"+st.size());
        System.out.println("Pop Element:"+st.pop());

        System.out.println("Top Element:"+st.peek());
        st.display();
        System.out.println("Size of the Stack"+st.size());
        System.out.println("Pop Element:"+st.pop());

        System.out.println("Top Element:"+st.peek());
        st.display();
        System.out.println("Size of the Stack"+st.size());
        System.out.println("Pop Element:"+st.pop());

        System.out.println("Empty:"+st.isEmpty());
        System.out.println("Full:"+st.isFull());



    }
}
