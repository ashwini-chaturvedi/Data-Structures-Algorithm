You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 2:

Input: s = "AABABBA", k = 1

Output: 4

Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

```java
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer>map=new HashMap<>();
        int i=0;
        int j=0;
        int ans=0;
        int maxCount=0;

        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            maxCount=Math.max(maxCount,map.get(s.charAt(j)));//store the maximum count 
            //we can change only those much of characters which are less than equal to k 
            //to ham maximum occured element ka count nikalenge and then current window size me se minus krdenge jo bchega woh hoga different characters that can be changed in k times to the major occuring character.
            
            while((j-i+1)-maxCount>k){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                if(map.get(s.charAt(i))<=0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            ans=Math.max(ans,j-i+1);
            
            j++;
        }

        return ans;
    }
}
```
