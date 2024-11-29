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
