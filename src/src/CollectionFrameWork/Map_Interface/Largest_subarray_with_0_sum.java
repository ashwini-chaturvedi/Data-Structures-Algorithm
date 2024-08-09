package CollectionFrameWork.Map_Interface;

import java.util.HashMap;
import java.util.Map;

public class Largest_subarray_with_0_sum {
    int maxLen(int[] arr, int n)
    {
        // Your code here
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int pSum=0;
        int len=0;
        for(int i=0;i<n;i++){
            pSum+=arr[i];
            if(map.containsKey(pSum)){
                len=Math.max((i-map.get(pSum)),len);


            }else{
                map.put(pSum,i);
            }
        }
        return len;
    }
    public static void main(String[]args){

    }
}
