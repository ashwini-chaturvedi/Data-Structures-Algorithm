package Graphs.DisjointUnionSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DSUBasics {
    public static int find(int num, int[] parents){
        if(num==parents[num]) return num;
        return find(parents[num],parents);
    }
    public static void makeUnion(int x,int y,int[] parents){
        int parentX=find(x,parents);
        int parentY=find(y,parents);
        if(parentX==parentY){
            parents[parentX]=parentY;
        }
        for(int num:parents){
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
      int[] parents={0,1,2,3,4,5,6};
      makeUnion(0,1,parents);


    }
}
