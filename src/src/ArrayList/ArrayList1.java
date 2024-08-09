package ArrayList;

import java.util.ArrayList;
public class ArrayList1 {
    public static void printArrayList(ArrayList<Integer>arraylist){

        for(int i:arraylist){
            System.out.print(" "+i);
        }


    }
    public static void main(String[]args){
        ArrayList<Integer>I=new ArrayList<>();
        for(int i=0;i<5;i++){
            I.add(i);
            System.out.print(" "+I.get(i));//printing values in Array List
        }

        I.add(5,78);//adding an element at any index after the length of the list
        System.out.println(I.get(5));

        I.add(0,67);
        System.out.println(I.get(0));//adding element at any Index and adding a place in front of the arraylist the element at that Index

        printArrayList(I);
        System.out.println("");

        I.set(1,90);//setting the target element at specified Index.
        printArrayList(I);
        System.out.println("");

        I.remove(6);//removing the element at guided Index.
        printArrayList(I);
        System.out.println("removed");

        I.remove(Integer.valueOf(67));//it will remove the value that is passed if that value exist in the ArrayList
        //if that value doesnot exist in the ArrayList it will just check and then leave the arrayList.

        printArrayList(I);
        System.out.println("");

        System.out.println("Direct Printing:"+I);

//        I.clear();
//        printArrayList(I);
//        System.out.println("cleared");

        printArrayList(I);
        System.out.println("\n size:"+I.size());

        printArrayList(I);
        System.out.println("\nIf Empty:"+I.isEmpty());

        I.ensureCapacity(9);
        printArrayList(I);
        System.out.println("");

        printArrayList(I);
        System.out.println("\n contains:"+I.contains(6));

        printArrayList(I);
        System.out.println("\n contains at:"+I.indexOf(67));
        I.add(89);
        I.add(89);
        I.add(89);
        printArrayList(I);
        System.out.println("");
        printArrayList(I);
        System.out.println("\n contains at:"+I.lastIndexOf(89));

        ArrayList list=new ArrayList();//makes the ArrayList without any boundation of any Wrapper class.
//        list.add(34);
//        list.add("Hii");
//        list.add(true);
//        System.out.println(list);





    }
}
