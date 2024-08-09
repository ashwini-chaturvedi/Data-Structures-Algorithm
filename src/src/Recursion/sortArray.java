package Recursion;

import java.util.ArrayList;

public class sortArray {
    //
    public static void sortRecursive(ArrayList<Integer>list){
        //base condition which will stop the recursive call..
        if(list.size()==1){
            return ;
        }
        //Induction:we have to write code here
        //MAKE THE INPUT SMALLER:---
        int temp=list.get(list.size()-1);//store the last element...
        list.remove(list.size()-1);//remove the last Element

        //Hypothesis which will sort all the other elements front index 1 to last
        sortRecursive(list);

//        Again Induction
        insertFunc(list,temp);
        return;
    }
    public static void insertFunc(ArrayList<Integer>list,int temp){
        //check kro ki temp bada ya barabr h last wale element se list ke
        //agr h toh add krdo taaki woh last me rhe aur maximum number bna rhe
        //agr nhi h toh pehle last element ko kahi store krlo aur usse list se remve krdo fir wapas se yehi function recursice call kro aur last me jb ek element bche aur
        //temp ki asli jgh miljaaye toh usko pehle list me add kro fir baad me val wali value jo ki store kiye the remove krke usko push krde list me...
        if(list.isEmpty() ||list.get(list.size()-1)<=temp){
            list.add(temp);
            return;
        }
        int val=list.get(list.size()-1);
        list.remove((list.size()-1));
        insertFunc(list,temp);
        list.add(val);
        return;
    }
    public static void main(String[]args){
        int[]arr={3,2,5,1,7};
        ArrayList<Integer>list=new ArrayList<>();
        for(int num:arr){
            list.add(num);
        }
       sortRecursive(list);


            System.out.print(list+",");


    }
}
