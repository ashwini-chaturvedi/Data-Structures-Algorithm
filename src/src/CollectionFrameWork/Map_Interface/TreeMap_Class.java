package CollectionFrameWork.Map_Interface;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMap_Class {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();//keys will be stored in binary search tree and map is sorted in Ascending order
//        All are sorted on the basis of keys
//        Keys are always Unique values may or may not be Unique
//         in this Example String are the keys which Should be Unique
        map.put("One", 1);// put is used to add the key and value pair into the Map
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Zero", 0);


        map.put("Zero", 9);
        map.get(1);
    }
}

