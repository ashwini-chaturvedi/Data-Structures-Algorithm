package SlidingWindow;

import java.util.TreeMap;

public class longestContinuousSubarrayWithLengthLessThanEqualToLimit {
    public static int maxLengthOfSubArray(int[]nums,int limit){
        TreeMap<Integer,Integer>map=new TreeMap<>();
        int i=0;
        int j=0;
        int maxLen=0;
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.lastKey()-map.firstKey()>limit){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }
            maxLen=Math.max(maxLen,(j-i+1));
            j++;
        }
        return maxLen;
    }
    public static void main(String[]args){
        int []nums={10,1,2,4,7,2};
        int limit=5;
        System.out.println(maxLengthOfSubArray(nums,limit));

    }
}
