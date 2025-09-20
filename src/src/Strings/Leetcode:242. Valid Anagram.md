# Optimized (Array[26])
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] count=new int[26];//to store the count of the characters 

        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;//if the character is present in second string decrease its count which means it is utilized.
        }

        for(int num:count){
            if(num!=0) return false;//if any character has other than 0 count which means it has appeared more or less times then it is utilized but valid anagram is only if exact count is there.
        }        
        return true;
    }
}
```
# HashMap
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
            int remove = map.get(ch);
            if (remove == 0) {
                map.remove(ch);
            }

        }
        if (map.isEmpty()) {
            return true;
        }

        return false;

    }
}


```
