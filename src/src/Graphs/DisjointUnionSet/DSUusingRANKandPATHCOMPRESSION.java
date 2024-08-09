package Graphs.DisjointUnionSet;

public class DSUusingRANKandPATHCOMPRESSION {
    public static int pathCompressedFIND(int num,int[]parents){
        if(num==parents[num]) return num;
        return parents[num]=pathCompressedFIND(parents[num],parents);
    }
    public static void rankUnion(int x,int y,int[]parents){
        int[] rank=new int[parents.length];
        int parentX=pathCompressedFIND(x,parents);
        int parentY=pathCompressedFIND(y,parents);
        if(parentX==parentY) return;
        if(rank[parentX]>rank[parentY]){
            parents[parentY]=parentX;
        }else if(rank[parentX]<rank[parentY]){
            parents[parentX]=parentY;
        }else{
            parents[parentY]=parentX;
            rank[parentX]++;
        }
    }
    public static void main(String[]args){
        int[] parents={0,1,2,3,4,5,6};

        rankUnion(0,1,parents);
    }
}
