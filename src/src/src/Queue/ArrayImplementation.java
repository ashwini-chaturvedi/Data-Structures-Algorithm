package Queue;
class queue{
    int capacity;
    int rear;
    int front;
    int[]array=new int[10];


    queue(int size){
        this.capacity=size;
        this.rear=this.front=0;

    }
   public boolean isEmpty(){
        return this.rear==this.front;

   }
   public boolean isFull(){
        return rear==capacity;
   }

    public void add(int val){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }else {
            array[rear] = val;
            rear++;
        }
    }
    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            int removeVal=array[front];
            front++;
            return removeVal;
        }
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            return array[front];
        }
    }
}
public class ArrayImplementation {
    public static void main(String[]args){
        queue q=new queue(10);
        System.out.println(q.isEmpty());
       for(int i=0;i<10;i++){
           q.add(i);
       }
        System.out.println(q.isFull());
//       System.out.println(q.remove());
//        System.out.println(q.remove());
//        System.out.println(q.remove());
//        System.out.println(q.remove());
//        System.out.println(q.remove());
//        System.out.println(q.peek());
    }
}
