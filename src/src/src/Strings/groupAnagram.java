package Strings;

import java.util.*;

public class groupAnagram {
    public static String sort(String str){
        char[]arr=str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public static List<List<String>>groupAnagramsSorting(String[]str){

        Map<String, List<String>>map=new HashMap<>();
        for(String s:str){
            String st=sort(s);
            if(!map.containsKey(st)){

                List<String>newList=new ArrayList<>();
                newList.add(s);
                map.put(st,newList);
            }else{
                List<String>existingList=map.get(st);
                existingList.add(s);

            }
        }
        List<List<String>>ans=new ArrayList<>();
        for(Map.Entry<String,List<String>>e:map.entrySet()){
            ans.add(new ArrayList<>(e.getValue()));
        }
        return ans;
    }
    public static String alignCharacters(String str) {
        int[] arr = new int[26];  // Array size should be 26
        for (char ch : str.toCharArray()) {
            int idx = ch - 'a';
            arr[idx]++;
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                for (int j = 0; j < arr[i]; j++) {
                    char ch = (char) (i + 97);  // Correct character calculation
                    s.append(ch);
                }
            }
        }
        return s.toString();
    }
    public static List<List<String>>groupAnagramsNoSorting(String[]strs){
        Map<String,List<String>>map=new HashMap<>();
        for(String str:strs){
            String st=alignCharacters(str);
            if(!map.containsKey(st)){

                List<String>newList=new ArrayList<>();
                newList.add(str);
                map.put(st,newList);
            }else{
                List<String>existingList=map.get(st);
                existingList.add(str);

            }
        }
        List<List<String>>ans=new ArrayList<>();
        for(Map.Entry<String,List<String>>e:map.entrySet()){
            ans.add(new ArrayList<>(e.getValue()));
        }
        return ans;
    }
    public static void main(String[]args){
        String []str={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagramsSorting(str));
        System.out.println(groupAnagramsNoSorting(str));
    }
}
