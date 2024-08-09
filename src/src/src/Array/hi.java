package Array;
import java.util.*;
import java.util.Arrays;

public class hi {
    public static void print(int[][]nums){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                System.out.println(nums[i][j]);
            }
        }
    }
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]>res=new ArrayList<>();
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        print(intervals);
        int []arr=new int[2];
        int []prevIdx=intervals[0];
        int i=1;
        int count=0;
        while(i<intervals.length){
            int prevStart=prevIdx[0];
            int prevEnd=prevIdx[1];
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];

            if(prevEnd<currStart){
                if(count==0){
                    res.add(prevIdx);
                }
                res.add(intervals[i]);
                prevIdx=intervals[i];
                i++;
                count++;
            }else{
                prevIdx[0]=Math.min(prevStart,currStart);
                prevIdx[1]=Math.max(prevEnd,currEnd);
                res.add(prevIdx);
                prevIdx=intervals[i];
                i++;
                count++;


            }

        }

        int [][]resultArray=new int[res.size()][2];
        resultArray=res.toArray(resultArray);

        return resultArray;
    }
    public static void main(String[]args){
        int [][] intervals={{1,4},{0,2},{3,5}};
        int [][]res=merge(intervals);

    }
}
