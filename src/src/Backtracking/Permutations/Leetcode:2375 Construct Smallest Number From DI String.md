You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

A 0-indexed string num of length n + 1 is created using the following conditions:

num consists of the digits '1' to '9', where each digit is used at most once.

If pattern[i] == 'I', then num[i] < num[i + 1].

If pattern[i] == 'D', then num[i] > num[i + 1].

Return the lexicographically smallest possible string num that meets the conditions.

 

Example 1:

Input: pattern = "IIIDIDDD"

Output: "123549876"

Explanation:

At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
Some possible values of num are "245639871", "135749862", and "123849765".
It can be proven that "123549876" is the smallest possible num that meets the conditions.
Note that "123414321" is not possible because the digit '1' is used more than once.

```java
class Solution {
    public boolean isValidToPut(String pattern,int idx,List<Integer>list,int digit){
       if(idx==0) return true;

        int prev=list.get(list.size()-1);

        if(pattern.charAt(idx-1)=='I'){//because 1 character aage h kyuki hme i se i+1 check krna tha
            return prev<digit;//If pattern[i] == 'I', then num[i] < num[i + 1].
        }

        return prev>digit;//If pattern[i] == 'D', then num[i] > num[i + 1].
        
    }
    public void  solve(String pattern,int idx,Set<Integer>isUsed,StringBuilder ans,List<Integer>list){
        if(ans.length()>0) return;

        if(idx==pattern.length()+1){
            for(int num:list){
                ans.append(num);
            }

            return;
        }

        for(int digit=1;digit<=9;digit++){//try every number from 1 to 9 to be put at the current place
            if(isUsed.contains(digit)) continue;

            if(isValidToPut(pattern,idx,list,digit)){
                list.add(digit);
                isUsed.add(digit);

                solve(pattern,idx+1,isUsed,ans,list);//Permutation Pattern

                list.remove(list.size()-1);
                isUsed.remove(digit);

            }
        }
    }
    public String smallestNumber(String pattern) {
       List<Integer>list=new ArrayList<>();
       StringBuilder ans=new StringBuilder();
       Set<Integer>isUsed=new HashSet<>();// to track that current number is already each digit is used at most once

       solve(pattern,0,isUsed,ans,list);

       return ans.toString(); 
    }
}
```
