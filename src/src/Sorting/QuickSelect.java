package Sorting;

class Solution {
    public static int partition(int[]num,int left,int right){
        int pivot=num[left];
        int i=left-1;
        int j=right;
        while(i<=j){
            if(pivot>num[i]&&pivot<num[j]){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
                i++;
                j--;
            }
            if(num[i]>=pivot){
                i++;
            }
            if(num[j]<=pivot){
                j--;
            }
        }
        int temp=num[j];
        num[j]=num[left];
        num[left]=temp;
        return j;
    }
    public static int findKthLargest(int[] nums, int k) {
        int L=0;
        int R=nums.length-1;
        int pivotIdx=0;


        while(true){
            pivotIdx=partition(nums,L,R);
            if(pivotIdx==k-1){
                break;
            }else if(pivotIdx>k-1){
                //pivot Index is greater than k-1 so we would likely to go on the left side.
                R=pivotIdx-1;
            }else{
                L=pivotIdx+1;
            }
        }
        return nums[pivotIdx];//returning the number at PivotIndex

    }
    public static void main(String[]args){

        int k=2;
        int max=0;
        int []nums={1,1,1,2,2,3};
        int [] res=new int[k];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        // Frequency Array
        int []freq=new int[max+1];
        for(int num:nums){
            freq[num]++;
        }
        for(int i=0;i<k;i++){
            res[i]= findKthLargest(freq,k-i);
        }
        for(int num:res){
            System.out.print(num+",");
        }
    }
}