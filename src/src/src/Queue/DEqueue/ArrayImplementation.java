package Queue.DEqueue;


class Deque {
    private int capacity;
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public Deque(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void insertFront(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert element at the front.");
            return;
        }
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        size++;
    }

    public void insertRear(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert element at the rear.");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete element from the front.");
            return -1;
        }
        int deletedValue = arr[front];
        front = (front + 1) % capacity;
        size--;
        return deletedValue;
    }

    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete element from the rear.");
            return -1;
        }
        int deletedValue = arr[rear];
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return deletedValue;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. No front element.");
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. No rear element.");
            return -1;
        }
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}



public class ArrayImplementation {
    public static void main(String[]args){
        Deque deque = new Deque(5);

        deque.insertFront(10);
        deque.insertRear(20);
        deque.insertFront(5);
        deque.insertRear(30);

        System.out.println("Front element: " + deque.getFront()); // Output: 5
        System.out.println("Rear element: " + deque.getRear());   // Output: 30

        deque.deleteFront();
        deque.deleteRear();

        System.out.println("Front element after deletion: " + deque.getFront()); // Output: 10
        System.out.println("Rear element after deletion: " + deque.getRear());   // Output: 20
    }
}
