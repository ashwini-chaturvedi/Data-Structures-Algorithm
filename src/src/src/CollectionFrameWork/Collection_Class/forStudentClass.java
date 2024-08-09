package CollectionFrameWork.Collection_Class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class forStudentClass {
    public static void main(String[]args){
        ArrayList<student>list=new ArrayList<>();
        list.add(new student("Anuj",2));
        list.add(new student("Ashwini",3));
        list.add(new student("Aieshi",4));
        list.add(new student("Aieshu",5));
        list.add(new student("Ashi",1));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        //Compareble bounds us wheather we want to compare the values by same type or we have to go and change the compare to method
        //So now comes Comparator for dynamically chnaging the parameter and getting the results.

        Collections.sort(list, new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                //this compares the value of both the objects and return the answer accordingly
                return o1.name.compareTo(o2.name);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        System.out.println(list);//here it is sorted on the basis of name


    }
}
