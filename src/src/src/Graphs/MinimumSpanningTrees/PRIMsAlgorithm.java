package Graphs.MinimumSpanningTrees;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// User function Template for Java
class trio{
    int weight;
    int child;
    int parent;
    trio(int w,int c,int p){
        weight=w;
        child=c;
        parent=p;
    }
}
public class PRIMsAlgorithm {
    public static int primS_Algo(int V, List<List<int[]>>adj){
        // Code Here.
        PriorityQueue<trio>minHeap=new PriorityQueue<>((a, b)->a.weight-b.weight);
        Set<Integer> inMST=new HashSet<>();
        int[] parents=new int[V];
        int sum=0;

        minHeap.add(new trio(0,0,-1));

        while(!minHeap.isEmpty()){
            trio curr=minHeap.remove();
            int currWt=curr.weight;
            int source=curr.child;
            int parent=curr.parent;

            if(inMST.contains(source)) continue;
            inMST.add(source);
            sum+=currWt;
            parents[source]=parent;

            for(int [] v:adj.get(source)){

                int neighbor=v[0];
                int wt=v[1];

                if(!inMST.contains(neighbor)){
                    minHeap.add(new trio(wt,neighbor,source));
                }

            }
        }
        return sum;
    }
    public static void main(String[]args){
        int a=9/10;
        System.out.println(a);
    }
}
