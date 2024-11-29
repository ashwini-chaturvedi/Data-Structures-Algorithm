# A Palindrome can only have 1 character which has odd frequency other should have even frequency
```java
class Solution {
    public int longestPalindrome(String s) {
        int res=0;
        Set<Character>set=new HashSet<>();
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){/*If a character is already in the set, it means we have encountered it again, forming a pair. At this point:
The character is removed from the set (as the pair is used up).
res is incremented by 2, as this pair contributes to the palindrome. */
                res+=2;
                set.remove(ch);
            }else{
                set.add(ch);//If a character is not in the set, it is added (this is the first occurrence of this character).

            }
        }
        if(!set.isEmpty()){/*At the end of the iteration, the Set contains only characters that appear an odd number of times.
For a palindrome, only one unpaired character can be used (it will sit at the center of the palindrome). If the Set is not empty, we add 1 to the result (res) to account for this. */
            res+=1;
        }
        return res;
    }
}
```
