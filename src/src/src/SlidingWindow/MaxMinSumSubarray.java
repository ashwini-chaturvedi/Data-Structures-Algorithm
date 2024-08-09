package SlidingWindow;
import java.util.*;

public class MaxMinSumSubarray {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here

        long i=0;
        long j=0;
        long res=Long.MIN_VALUE;
        long sum=0;
        while(j<N){
            sum+=Arr.get((int)j);
            if((j-i)+1<K){
                j++;
            }else if((j-i)+1==K){
                res=Math.max(res,sum);
                sum-=Arr.get((int)i);
                i++;
                j++;
            }
        }
        return res;
    }
    public static void main(String[]args){
       ArrayList<Integer> arr=new ArrayList<>();
       arr.add(100);
        arr.add(200);
        arr.add(300);
        arr.add(400);
       int k=2;
       System.out.print(maximumSumSubarray(k,arr,4));
    }
}
