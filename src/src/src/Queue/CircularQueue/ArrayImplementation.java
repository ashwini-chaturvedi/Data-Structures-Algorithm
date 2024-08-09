package Queue.CircularQueue;

class CircularQueue {
    int front = 0;
    int rear = 0;
    int[] arr = new int[10];
    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int val) throws Exception {
        if (size == arr.length - 1) {
            throw new Exception("Queue is Full");
        }
        arr[rear] = val;
        rear = (rear + 1) % arr.length;
        size++;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        int removeVal = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return removeVal;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        return arr[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        if (front <= rear) {
            for (int i = front; i < rear; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            for (int i = front; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i < rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}

public class ArrayImplementation {
    public static void main(String[] args) throws Exception {
        CircularQueue cq = new CircularQueue();

        for (int i = 0; i < 9; i++) {
            cq.add(i);
        }
        cq.display();
        cq.remove();
        cq.add(890);
        cq.remove();
        cq.remove();
        cq.remove();
        cq.remove();

        cq.add(80);

        cq.display();
        for (int i = 0; i < 10; i++) {
            System.out.print(cq.arr[i] + " ");
        }
    }
}
