```java
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count=0;
        for(String s:words){
            if(s.startsWith(pref)){//Check for each String has a Prefix 'pref'
                count++;
            }
        }
        return count;
    }
}
```
