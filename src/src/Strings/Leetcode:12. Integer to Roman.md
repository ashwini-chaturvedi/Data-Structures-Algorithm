```java
class Solution {
    public String intToroman(Map<Integer,String>map,int num){
        StringBuilder result=new StringBuilder();
        for(Map.Entry<Integer,String>entry:map.entrySet()){
            int value=entry.getKey();
            String romanNum=entry.getValue();
            while(num>=value){
                result.append(romanNum);
                num-=value;
            }
        }
        return result.toString();
    }
    public String intToRoman(int num) {
        Map<Integer,String>map=new TreeMap<>(Collections.reverseOrder());//this will store the values in Descending order in TreeMap
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
        
        return intToroman(map,num);
    }
}
```
