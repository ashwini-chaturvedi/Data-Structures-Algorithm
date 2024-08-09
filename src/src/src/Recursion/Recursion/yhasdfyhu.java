package Recursion.Recursion;

public class yhasdfyhu {


        public int[] productExceptSelf(int[] nums) {
            int res0=0;
            int res1=0;
            int count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    res1*=nums[i];
                    count++;
                }else{
                    if(i==0){
                        res0+=1;
                        res1+=1;
                    }
                    if(res0==0){
                        res0++;
                    }
                    res0*=nums[i];
                    res1*=nums[i];
                }
            }
            int c=1;
            if(count>1){
                c=0;
            }
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    if(c!=count){
                        nums[i]=res0*0;
                        c++;
                    }else {
                        nums[i]=res0;
                    }


                }else{
                    nums[i]=res1/nums[i];
                }
            }
            return nums;
        }
    }

