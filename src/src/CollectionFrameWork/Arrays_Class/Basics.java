package CollectionFrameWork.Arrays_Class;

import java.util.Arrays;
import java.util.List;

public class Basics {
    public static void display(int[]arr){
        for(int num:arr){

            System.out.print(num+",");
        }
        System.out.println();
    }
    public static void main(String[]args){
        int[]arr={1,2,3,4,5,6,7,8,9,0};

        System.out.println(Arrays.binarySearch(arr,4));

        Arrays.sort(arr);//for sorting it follows Quick sort and uses O(nlogn) time...
        display(arr);

        Arrays.fill(arr,38);
        display(arr);
        int[]brr={1,2,3,4,5,6,7,8,9,0};
        int[]crr={1,2,3,4,5,6,7};


        System.out.println(Arrays.compare(arr,brr));
        System.out.println( Arrays.toString(arr));
        System.out.println(Arrays.mismatch(crr,brr));


    }
}
