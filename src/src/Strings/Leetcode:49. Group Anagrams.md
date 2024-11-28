```java
class Solution {
    public String sort(String str){
        char[]arr=str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        //Take the String to make it a key sort it which will make the key a unique identifier
        Map<String,List<String>>map=new HashMap<>();
        for(String str:strs){

            String s=sort(str);//makes the String as unique identifier for the Strings have same characters and same number of occurences

            map.putIfAbsent(s,new ArrayList<>());
            map.get(s).add(str);    
        }

        List<List<String>>list=new ArrayList<>();
        //Traverse the Map
        for(Map.Entry<String,List<String>>entry:map.entrySet()){
            list.add(new ArrayList<>(entry.getValue()));
        }
        return list;
    }
}
```
