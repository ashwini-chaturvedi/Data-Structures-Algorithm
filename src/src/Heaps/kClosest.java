package Heaps;

import java.util.*;

class pair{
    int key;
    int val;
    pair(int k,int v){
        key=k;
        val=v;
    }
}
public class kClosest {

        public static List<Integer> findClosestElements(int[] arr, int k, int x) {

            PriorityQueue<pair> maxHeap = new PriorityQueue<>((a, b) -> {
                if (a.key != b.key) {
                    return b.key - a.key; // max-heap based on key (absolute difference)
                } else {
                    return b.val - a.val; // handle tie by value (optional)
                }
            });

            for(int num:arr){
                maxHeap.add(new pair(Math.abs(num-x),num));
                if(maxHeap.size()>k){
                    maxHeap.remove();
                }
            }

            List<Integer>list=new ArrayList<>();
            while(!maxHeap.isEmpty()){
                list.add(maxHeap.remove().val);
            }
            Collections.sort(list);
            return list;
        }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        int k = 4, x = 3;
        System.out.println(findClosestElements(arr,k,x));
        Map<Character,Integer>map=new HashMap<>();
       map.put('A',2);
       map.put('a',7);
       char a=0;
       int b=0;
       for(char n:map.keySet()){
         a=n;// key traverse
         b=map.get(n);//value of the key n
       }
        System.out.println(a);//
        System.out.println(b);
    }

}
