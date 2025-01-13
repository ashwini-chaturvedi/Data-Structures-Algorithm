```java
class Solution {

    public int minimumLength(String s) {
        if (s.length() < 3) return s.length(); //if length is less than 3 then we can not perform operation on it not once.

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int len = 0;
        for (var e : map.entrySet()) {
            int val = e.getValue();
            if (val >= 3) { //if the Frequency is greater then 3.then reduce it until it become less then 3.
                int rem = 0;
                int div = 0;
                while (val >= 3) {
                    rem = val % 3;
                    div = val / 3;

                    val = rem + div; //new val will become the sum of reminder and division
                }
                len += (rem + div);
            } else {
                len += e.getValue();//if the frequency is less than 3 then all the characters will be added to it.No number of operations can be done on it.
            }
        }

        return len;
    }
}

```
