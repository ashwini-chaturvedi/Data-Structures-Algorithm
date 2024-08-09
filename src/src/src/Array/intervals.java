package Array;
import java.util.*;

public class intervals {
    public static int[][] merge(int[][] intervals) {
        int []newInterval=new int[2];
        ArrayList<int[]>res=new ArrayList<>();
        int i=0;
        while(i<intervals.length){
            newInterval[0]=intervals[i][0];
            newInterval[1]=intervals[i][1];
            if(intervals[i][0]<newInterval[0]){
                res.add(intervals[i]);
                i++;
            }else if(intervals[i][0]>newInterval[1]){
                res.add(newInterval);
            }else{
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }
            i++;
        }
        while(i<intervals.length){
            res.add(intervals[i]);
            i++;
        }
        int [][]resArray=new int[res.size()][2];
        for(int j=0;j<res.size();j++){
            resArray[j]=res.get(j);
        }
        return resArray;
    }
    public static void main(String[]args){
        int [][] intervals={
                {1,3},
                {2,6},
                {8,10},
                {15,20}
        };
        int[][]res=merge(intervals);
        for(int i=0;i< intervals.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(res);
            }
        }

    }
}
