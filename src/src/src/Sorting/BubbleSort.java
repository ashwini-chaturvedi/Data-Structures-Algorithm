package Sorting;

public class BubbleSort {
    public static void optimizedBubbleSort(int[]arr){
        for(int i=0;i<arr.length;i++){
            boolean flag=false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    //swapping using BITWISE xor.
                    arr[j]=arr[j]^arr[j+1];
                    arr[j+1]=arr[j]^arr[j+1];
                    arr[j]=arr[j]^arr[j+1];
                    flag=true;
                }
            }
            if(!flag){
                return;
            }
        }
    }
    public static void normalBubbleSortDecending(int[]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }
        }
    }
    public static void main(String[]args){
        int []arr={2,4,6,32,6,23,4,54};

        for(int num:arr){
            System.out.print(" "+num);
        }
        System.out.println();
        normalBubbleSortDecending(arr);
        for(int num:arr){
            System.out.print(" "+num);
        }
        System.out.println();
        optimizedBubbleSort(arr);
        for(int num:arr){
            System.out.print(" "+num);
        }
    }
}
