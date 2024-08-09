package Sorting;

public class MergeSort {

    public static void mergesort(int[]nums,int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;

        mergesort(nums,left,mid);
        mergesort(nums,mid+1,right);
        merge(nums,left,mid,right);
        return;
    }
    public static void merge(int[]nums,int Fidx,int mid,int Lidx){
        int an=mid-Fidx+1;
        int []firstHalf=new int[an];
        for(int i=0;i<an;i++){
            firstHalf[i]=nums[Fidx+i];
        }
        int bn=Lidx-mid;
        int []secondHalf=new int [bn];
        for(int i=0;i<bn;i++){
            secondHalf[i]=nums[mid+1+i];
        }

        int i=0;
        int j=0;
        int k=Fidx;
        while(i<an&&j<bn){
            if(firstHalf[i]<secondHalf[j]){
                nums[k]=firstHalf[i];
                i++;
                k++;
            }else{
                nums[k]=secondHalf[j];
                j++;
                k++;
            }
        }
        while(i<an){
            nums[k]=firstHalf[i];
            i++;
            k++;
        }
        while(j<bn){
            nums[k]=secondHalf[j];
            k++;
            j++;
        }

    }
    public static void main(String[]args){
        int []arr={23,34,63,23,4,23,56,79};
        mergesort(arr,0,arr.length-1);
        for(int num:arr){
            System.out.print(num+",");
        }
    }
}
