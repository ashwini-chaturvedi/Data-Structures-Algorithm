package Queue;
//{ Driver Code Starts
import java.util.*;






class Solutions {
    public  ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q) {
        // code here
        Stack<Integer>st=new Stack<>();
        int size=q.size();

        for(int i=1;i<=(size/2);i++){
            st.push(q.remove());
        }
        while(!st.empty()){
            q.add(st.pop());
        }
        for(int i=1;i<=(size/2);i++){
            st.push(q.remove());
        }
        while(!st.empty()){
            q.add(st.pop());
            q.add(q.remove());
        }

        ArrayList<Integer>arr=new ArrayList<>();
        while(!q.isEmpty()){
            arr.add(0,q.remove());
        }
        return arr;
    }
}
//3 6 7 8 5 9

public class djj {
    public static void main(String[] args) {
        Queue<Integer>q=new LinkedList<>();

        q.add(3);
        q.add(7);
        q.add(5);
        q.add(6);
        q.add(8);
        q.add(9);

        Solutions s=new Solutions();
        System.out.println(s.rearrangeQueue(6,q));


    }
}
