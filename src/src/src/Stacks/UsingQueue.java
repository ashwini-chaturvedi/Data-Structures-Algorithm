package Stacks;
import java.util.*;
class MyStack {
    Queue<Integer>main=new LinkedList<>();
    Queue<Integer>aux=new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        aux.add(x);
        while(!main.isEmpty()){
            aux.add(main.remove());
        }
        //swap the references
        Queue<Integer>temp=main;
        main=aux;
        aux=temp;
    }

    public int pop() {
        if(empty()){
            return -1;
        }

        return main.remove();
    }

    public int top() {
        if(empty()){
            return -1;
        }

        return main.peek();
    }

    public boolean empty() {
        return main.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class UsingQueue {
}
