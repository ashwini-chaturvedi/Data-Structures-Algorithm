```java
class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()==k) return true;
        if(s.length()<k) return false;
        

        Map<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int allowed=k;

        for(var e:map.entrySet()){
            if(e.getValue()%2!=0){
                allowed--;
            }
            
        }

        return allowed>=0?true:false;
    }
}

```
