package Queue;

import java.util.LinkedList;
import java.util.*;

public class practice {
    public static void revers(Queue<Integer>main,Stack<Integer>aux){
        while(!main.isEmpty()){
            aux.push(main.remove());
        }
        while(!aux.empty()){
            main.add(aux.pop());
        }
    }
    public static void main(String[]args){
        Queue<Integer> main=new LinkedList<>();
        for(int i=0;i<6;i++){
            main.add(i);
        }
        System.out.println(main);
        Stack<Integer>aux=new Stack<>();
        revers(main,aux);
        System.out.println(main);
    }
}
