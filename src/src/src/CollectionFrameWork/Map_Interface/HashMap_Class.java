package CollectionFrameWork.Map_Interface;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMap_Class {

    public static void main(String[]args){
        //this Stores Key->Value pair or it stores key and its respective value int pairs...
        Map<String,Integer> map=new HashMap<>();
        Map<String,Integer>m=new LinkedHashMap<>();
        //Keys are always Unique values may or may not be Unique
        // in this Example String are the keys which Should be Unique
        map.put("One",1);// put is used to add the key and value pair into the Map
        //Most of the Operations are the Constant time Operation...
        map.put("Two",2);
        map.put("Three",3);
        map.put("Zero",0);


        map.put("Zero",9);
        //when you try to Insert any duplicate value of a previously Inserted key then the value gets Override... 0 becomes 9

        System.out.println(map);

        System.out.println(map.containsKey("Two"));
        System.out.println(map.containsValue(1));

        System.out.println(map.isEmpty());
        map.putIfAbsent("Two",5);
        System.out.println(map);

        //Iterating over a map
        for(Map.Entry<String,Integer> num:map.entrySet()){
            System.out.print(num+",");
        }
        System.out.println();
        for(Map.Entry<String,Integer> num:map.entrySet()){
            System.out.print(num.getKey()+",");
        }
        System.out.println();
        for(Map.Entry<String,Integer> num:map.entrySet()){
            System.out.print(num.getValue()+",");
        }

        //new way to traverse a HashMap using 'var'
        System.out.println();
        for(var num:map.entrySet()){
            System.out.print(" new:"+num.getKey());


        }
        Map<Character,Integer> map1=new HashMap<>();
        map1.put('c',3);
        Map<Character, Integer> temp = new HashMap<>();
        temp.putAll(map1);
        System.out.println("Temp>>>>>>>>>>"+temp);

        System.out.println();
        //only for key
        for(String key:map.keySet()){
            System.out.print(key+",");
        }
        System.out.println();

        //only for Values
        for(Integer value:map.values()){
            System.out.print(value+",");
        }
        map.putIfAbsent("ij",8);

        System.out.println("uu:"+ (int)(Math.pow(2,3)/2));
        System.out.printf("%d%d%d",54,54,43);
        Map<Integer,Integer> map2=new HashMap<>();
        map2.put(2,1);
        map2.put(2,map.get(2)+1);

        while(map2.get(2)!=0){
            System.out.println(map2.values());
        }
    }
}
