Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

![img](https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png)

Input: digits = "23"

Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

```java
class Solution {
    public void solve(String digit,Map<Character,String>map,List<String>list,String op,int idx){
        if(idx==digit.length()){
            if(op.length()==digit.length()){
                list.add(op);
            }
            
        }

        for(int i=idx;i<digit.length();i++){
            String chars=map.get(digit.charAt(i));

            for(char ch:chars.toCharArray()){
                op+=ch;

                solve(digit,map,list,op,i+1);//Combination=>i+1

                op=op.substring(0,op.length()-1);
            }
        }

    }
    public List<String> letterCombinations(String digits) {
        Map<Character,String>map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String>list=new ArrayList<>();
        String op="";

        solve(digits,map,list,op,0);

        return list;
    }
}
```
