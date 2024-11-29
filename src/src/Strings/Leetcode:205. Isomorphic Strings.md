```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character>map=new HashMap<>();
        //for constant or linear time complexity we will use set
        Set<Character>set=new HashSet<>();//Using set to match the occurence of the tChar so that the tChar cannot be binded with more than one character from String s.
        for(int i=0;i<s.length();i++){
            Character sChar=s.charAt(i);
            Character tChar=t.charAt(i);

            if(map.containsKey(sChar)){
                if(map.get(sChar)!=tChar) return false;
            } else if(set.contains(tChar)) return false;
            else{
                map.put(sChar,tChar);//Map the tChar with sChar
                set.add(tChar);//already encountered tChar
            }    
      
        }
        return true;
    }    
}
```
