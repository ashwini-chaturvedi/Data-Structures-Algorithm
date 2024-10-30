```java
class Solution {

    public int romanToInt(String s) {
        //Store the countings in a Map
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int val = 0;
        //Start Solving from End of the String 
        val += map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
//when you encounter any Character that has less value then the Previous character then Minus the current Value with the total value it shows that IV(4) becomes 5-1=4 which is correct value.
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                val -= map.get(s.charAt(i));
            } else {
                val += map.get(s.charAt(i));
            }
        }
        return val;
    }
}
```
