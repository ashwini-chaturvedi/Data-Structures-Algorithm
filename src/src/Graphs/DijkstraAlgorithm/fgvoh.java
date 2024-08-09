package Graphs.DijkstraAlgorithm;

import java.util.*;

class duel{
    int distt;
    int[] arr;
    duel(int a,int[] res){
        distt=a;
        arr=res;
    }
}
public class fgvoh {
    public static void main(String[] args) {
        PriorityQueue<duel>pq=new PriorityQueue<>((a,b)->b.distt-a.distt);
        pq.add(new duel(0,new int[]{0,0}));
        pq.add(new duel(2,new int[]{1,0}));
        pq.add(new duel(1,new int[]{0,1}));
        while(!pq.isEmpty()){
            System.out.println(pq.remove().distt);
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        map.put(2,3);
        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            System.out.println("Key:"+e.getKey());
            System.out.println("Value:"+e.getValue());
        }
        int[] res={-1,2,5,3,-6};
        Arrays.sort(res);

    }
}
