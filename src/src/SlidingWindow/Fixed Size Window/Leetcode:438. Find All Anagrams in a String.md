Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"

Output: [0,6]

Explanation:

The substring with start index = 0 is "cba", which is an anagram of "abc".

The substring with start index = 6 is "bac", which is an anagram of "abc".

```java
class Solution {
    public boolean checkAllZero(int[] arr){
        for(int num:arr){
            if(num!=0) return false;
        }

        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>list=new ArrayList<>();

        int[] arr=new int[26];

        for(char ch:p.toCharArray()){
            arr[ch-'a']++;
        }

        int i=0;
        int j=0;

        while(j<s.length()){
            char ch=s.charAt(j);
            arr[ch-'a']--;

            if(j-i+1==p.length()){
                if(checkAllZero(arr)){
                    list.add(i);
                }
                arr[s.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return list;
    }
}
```
