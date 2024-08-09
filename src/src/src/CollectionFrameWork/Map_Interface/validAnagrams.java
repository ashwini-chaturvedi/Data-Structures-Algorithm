package CollectionFrameWork.Map_Interface;

import java.util.HashMap;
import java.util.Map;

public class validAnagrams {
    public static boolean validAnagram(String s,String t){
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }


        }
        System.out.println(map);

        for(char ch:t.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
            }else{
                return false;
            }
            int remove=map.get(ch);
            if(remove==0){
                map.remove(ch);
            }

        }
        if(map.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
    public static void main(String[]args){
        String s="listen";
        String t="silent";
        System.out.println(validAnagram(s,t));
    }
}
