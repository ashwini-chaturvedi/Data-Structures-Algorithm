package Sorting;

public class oisshoif {

        public static void countSort(int []nums,int pos){
            int []freq=new int[10];
            for(int i=0;i<nums.length;i++){
                freq[(nums[i]/pos)%10]++;
            }
            for(int i=1;i<freq.length;i++){
                freq[i]+=freq[i-1];
            }
            int []ans=new int[nums.length];
           for(int i=nums.length-1;i>=0;i--){
               int idx=freq[(nums[i]/pos)%10]-1;
               ans[idx]=nums[i];
               freq[(nums[i]/pos)%10]--;
           }
            for(int i=0;i<nums.length;i++){
                nums[i]=ans[i];
            }

        }
        public static void adixSort(int[]nums){
            int max=0;
            for(int i=0;i<nums.length;i++){
                max=Math.max(nums[i],max);
            }
            for(int pos=1;max/pos>0;pos*=10){
                countSort(nums,pos);
            }
        }


    public static void main(String[]args){
        int []nums={15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        System.out.print("Unsorted Array:\n");
        for(int num:nums){
            System.out.print(num+",");
        }
        adixSort(nums);
        System.out.println("\nSorted Array:");

        for(int num:nums){
            System.out.print(num+",");
        }

        int maxVal=0;
        for(int i=1;i<nums.length;i++){
            int diff=nums[i]-nums[i-1];
            if(diff>maxVal){
                maxVal=diff;
            }
        }
        System.out.println("\nmax:"+maxVal);

    }
}
