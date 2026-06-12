Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"

Output: "BANC"

Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.


```java
class Solution {

    public boolean isAllZeroORLesser(Map<Character, Integer> map) {
        for (var num : map.entrySet()) {
            if (num.getValue() > 0) return false;
        }

        return true;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int j = 0;
        String ans = "";
        //Make the Frequency Array Here and check the frequency of t and basis of that don't have to call the method

        while (j < s.length()) {
            char ch = s.charAt(j);

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            while (i <= j && (j - i + 1) >= t.length() && isAllZeroORLesser(map)) {
                if (ans.equals("") || ans.length() > s.substring(i, j + 1).length()) {
                    ans = s.substring(i, j + 1);
                }
                char ch1 = s.charAt(i);

                map.put(ch1, map.getOrDefault(ch1, 0) + 1);

                i++;
            }
            j++;
        }

        return ans;
    }
}

```


```java
class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer>tMap=new HashMap<>();
        for(char ch:t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }
        int required=tMap.size();
        int start=0;
        int minLen=Integer.MAX_VALUE;
        int found=0;
        Map<Character,Integer>inWindow=new HashMap<>();
        int i=0;
        int j=0;
        
        int seen=0;
        while(j<s.length()){
            //earlier hmko problem horhi thi total actual count rkh pana hrr ek element ka and then hm 2 maps ka use kiye ek me kya hme kitne count me dhundhna h woh rkhe and dusre me current window me kis element ko rkha h 
            char ch=s.charAt(j);
            inWindow.put(ch,inWindow.getOrDefault(ch,0)+1);

            if(tMap.containsKey(ch) && inWindow.get(ch).intValue()==tMap.get(ch).intValue()){
                found++;
            }

            while(found==required){
                if((j-i+1)<minLen){
                    minLen=j-i+1;
                    start=i;
                }

                char toRemove=s.charAt(i);

                inWindow.put(toRemove,inWindow.getOrDefault(toRemove,0)-1);

                if(tMap.containsKey(toRemove) && inWindow.get(toRemove)<tMap.get(toRemove)){
                    found--;
                }
                i++;
            }
            j++;
        }

        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}
```
