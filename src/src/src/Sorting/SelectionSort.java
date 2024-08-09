package Sorting;

public class SelectionSort {
    public static void SelectionSort(int[]nums){
        for(int i=0;i<nums.length;i++){
            int minIdx=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[minIdx]){
                    minIdx=j;
                }
            }
           int temp=nums[i];
            nums[i]=nums[minIdx];
            nums[minIdx]=temp;
        }
    }
    public static void sortInLexicographical(String []str){
        for(int i=0;i<str.length;i++){
            int minIdx=i;
            for(int j=i+1;j<str.length;j++){
                if(str[j].compareToIgnoreCase(str[minIdx])<0){
                    //this means that str[j] element is smaller than str[minIdx]
                    //compareTo and compareToIgnoreCase these are 2 inbuilt functions to compare string.
                    minIdx=j;

                }
            }
            String temp=str[i];
            str[i]=str[minIdx];
            str[minIdx]=temp;
        }
    }
    public static void main(String[]args){
        int []arr={23,34,63,23,4,23,56,79};
        SelectionSort(arr);
        for(int num:arr){
            System.out.print(num+",");
        }
        System.out.println();
        String []str={"mango","Banana","strawberry","apple","pineapple","grapes","orange"};
        sortInLexicographical(str);
        for(String s:str){
            System.out.print(s+",");
        }
    }
}
