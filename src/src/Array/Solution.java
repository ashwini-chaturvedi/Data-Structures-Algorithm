package Array;

public class Solution {
//    public static int findMaxLength(int[] nums) {
//        int []res=new int[nums.length];
//        res[0]=nums[0];
//        for(int i=1;i<nums.length;i++){
//            res[i]=nums[i]+res[i-1];
//        }
//        if(nums[nums.length-1]==1&&nums[nums.length-2]==1){
//            return res[res.length-1];
//        }else{
//            return (2*res[res.length-1]);
//        }
//
//    }

//        public static int findMaxLength(int[] nums) {
//            int count0=0;
//            int count1=0;
//            for(int i=0;i<nums.length;i++){
//                if(nums[i]==0){
//                    count0++;
//                }else{
//                    count1++;
//                }
//            }
//            if(count0<count1){
//                return (2*count0);
//            }else if(count0>count1){
//                return (2*count1);
//            }else{
//                return (2*count1);
//            }
//        }


        public static int findMaxLength(int[] nums) {
            int curr=nums.length;
            int []referenceArray=new int[2*nums.length+2];//to store the index of first occurence of each possible vale of current
            int res=0;
            for(int i=0;i<nums.length;i++){
                curr+=(nums[i]<<1)-1;//this operation maps 0 to -1 and 1 to 1 effectively incrementing or decrementing value of current and hence finding the occurence of a specific element is repeated or not.
                //left Shifting and Adding the current to it which will map it in correct order.
                if(curr==nums.length){
                    res=i+1;//this will add the correct number of elements that can be contiguous subarray.
                }else if(referenceArray[curr]==0){
                    //shows that if the element has not occured before ad it to its respective index in referenceArray.
                    referenceArray[curr]=i+1;
                }else{
                    //this means we have encoutered this element before and increased the result according to it
                    //So now we will find the length of subarray between the currentIdx (i) and Index Stored in referenceArray[curr].
                    res=Math.max(res,i-referenceArray[curr]+1);
                }
            }
            return res;
        }



    public static void main(String[]args){
        int []nums={0,1,1,0,1,1,1,0};
        System.out.println(findMaxLength(nums));

    }
}
