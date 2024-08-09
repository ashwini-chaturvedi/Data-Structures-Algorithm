package Queue;
import java.util.*;
class MyQueue {
    Stack<Integer>mainStack=new Stack<>();
    Stack<Integer>auxStack=new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        mainStack.push(x);
    }

    public int pop() {
        if(empty()){
            return -1;
        }
        if(auxStack.empty()){
            while(!mainStack.empty()){
                auxStack.push(mainStack.pop());
            }
        }
        return auxStack.pop();
    }

    public int peek() {
        if(empty()){
            return -1;
        }
        if(auxStack.empty()){
            while(!mainStack.empty()){
                auxStack.push(mainStack.pop());
            }
        }
        return auxStack.peek();
    }

    public boolean empty() {
        return mainStack.empty()&&auxStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class StackImplemntation {
    public static void main(String[]args){

    }
}
