package Queue;

import java.util.*;

public class IPO_MaxHeap {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }

        projects.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;

        while (k-- > 0) {
            while (i < n && projects.get(i)[0] <= w) {
                maxProfitHeap.add(projects.get(i)[1]);
                i++;
            }
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            w += maxProfitHeap.poll();
        }
        return w;
    }
    public static void main(String[]args){
        int w=0;
        int k=2;
        int[]profits={1,2,3};
        int[]capital={0,1,1};


        List<int[]> list=new ArrayList<>();
        for(int i=0;i<profits.length;i++){
            list.add(new int[]{capital[i],profits[i]});
        }
        list.sort(Comparator.comparingInt(a->a[0]));

        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;

        while(k-->0){
            while(i<profits.length&&list.get(i)[0]<=w){
                pq.add(list.get(i)[1]);
                i++;
            }
            if(pq.isEmpty()){
                break;
            }
            w+=pq.poll();
        }
        System.out.println(w);

        System.out.println( findMaximizedCapital(k,w,profits,capital));
    }
}
