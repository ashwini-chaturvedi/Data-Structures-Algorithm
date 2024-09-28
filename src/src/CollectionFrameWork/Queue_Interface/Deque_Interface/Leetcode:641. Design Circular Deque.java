// Making array Circular Fromula
//1. While Inserting:
    //front=(front-1+capacity)%capacity;
    //rear=(rear+1)%capacity;
//2. While Deleting:
    //front=(front+1)%capacity;
    //rear=rear=(rear-1+capacity)%capacity;
// Just Switch the formulas...
class MyCircularDeque {
    int[] nums;
    int front;
    int rear;
    int capacity;
    int size;
    public MyCircularDeque(int k) {
        nums=new int[k];
        front=0;
        rear=0;
        capacity=k;
        size=0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;

        //We have to Maintain a Circular Structure
        front=(front-1+capacity)%capacity;
        nums[front]=value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        nums[rear]=value;
        rear=(rear+1)%capacity;
       
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;

        front=(front+1)%capacity;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;

        rear=(rear-1+capacity)%capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        return isEmpty()?-1:nums[front];
    }
    
    public int getRear() {
        //now we are accessing from rear without inserting from rear so we will circle the Index
        
        return isEmpty()?-1:nums[(rear-1+capacity)%capacity];//this will give the circular Index to the rear
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
