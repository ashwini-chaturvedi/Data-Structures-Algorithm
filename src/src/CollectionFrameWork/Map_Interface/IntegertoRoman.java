package CollectionFrameWork.Map_Interface;
import java.util.*;

public class IntegertoRoman {
    public static Map<Integer,String>Mapping(){
        //we will Store the Elements in Reverse Order
        Map<Integer,String>map=new TreeMap<>(Collections.reverseOrder());

        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        return map;
    }
    public static String integerToRoman(int num){
        Map<Integer,String>intRomanmap=Mapping();
        StringBuilder result=new StringBuilder();
        for(Map.Entry<Integer,String>entry:intRomanmap.entrySet()){

            int value=entry.getKey();
            String romanNum=entry.getValue();
            while(num>=value){
                result.append(romanNum);
                num-=value;
            }
        }
        return result.toString();
    }
    public static void main(String[]args){
        Scanner Input=new Scanner(System.in);
        System.out.print("Enter the Integer Number:");
        int num=Input.nextInt();
        System.out.println("Roman Number:"+integerToRoman(num));
    }
}
