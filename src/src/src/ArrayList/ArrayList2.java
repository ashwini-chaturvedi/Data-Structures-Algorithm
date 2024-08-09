package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayList2 {
    public static void reverseList(ArrayList<Integer> list){
        int i=0;
        int j=list.size()-1;
        while(i<j){
            //Swapping Elements of ArrayList.
           Integer temp=Integer.valueOf(list.get(i));
           list.set(i,list.get(j));
           list.set(j,temp);
           i++;
           j--;
        }

 }
 public static void takeInput(ArrayList<Integer>list){

     Scanner Input=new Scanner(System.in);
     System.out.print("Enter the size of ArrayList:");
     int size=Input.nextInt();
     System.out.println("Enter the element of ArrayList:");
     for(int i=0;i<size;i++){
         int j=Input.nextInt();
         list.add(i,j);
     }
 }
    public static void main(String[]args){
        ArrayList<Integer>list=new ArrayList<>();
        takeInput(list);
        System.out.println(list);
        //1st way
        reverseList(list);
        System.out.println(list);
        //2nd way
        Collections.reverse(list);//Using the Collection class and it's Inbuilt method reverse.
        System.out.println(list);

        //sorting list using Inbuilt Functions
        Collections.sort(list);
        System.out.println("Ascending Order:"+list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println("Descending Order:"+list);

    }
}
