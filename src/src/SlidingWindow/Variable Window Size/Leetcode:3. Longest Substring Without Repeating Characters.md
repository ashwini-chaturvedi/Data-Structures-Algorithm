```java
class Solution {
    public int lengthOfLongestSubstring(String s) {

        //Sliding Window...
        Set<Character> set=new HashSet<>();
        int i=0;
        int j=0;
        int maxLen=0;

        while(j<s.length()){
            
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
                              
            }
            maxLen=Math.max(maxLen,j-i+1);//Calculating the length after removing the duplicate Item
            set.add(s.charAt(j));
            
            j++;
        }

        return maxLen;
    }
} 
```
