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

# Backtracking
```java
class Solution {
    //Time Complexity:O(2^N ∗ N!)
    //Make a String having 1 to n+1 numbers
    //then find all the permutations of the String and check if it is valid or not if it is valid store it in the list
    //then sort the list so that we can get the lexicographically smallest String.
    public boolean isValid(String pattern,StringBuilder sb){
        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i)=='I'){//If pattern[i] == 'I', then num[i] < num[i + 1].
                int num1=sb.charAt(i)-'0';
                int num2=sb.charAt(i+1)-'0';

                if(num1>num2) return false;
            }else if(pattern.charAt(i)=='D'){//If pattern[i] == 'D', then num[i] > num[i + 1].
                int num1=sb.charAt(i)-'0';
                int num2=sb.charAt(i+1)-'0';

                if(num1<num2) return false;
            }
        }

        return true;
    }
    public void swap(StringBuilder sb,int i,int idx){
        char temp=sb.charAt(i);
        sb.setCharAt(i,sb.charAt(idx));
        sb.setCharAt(idx,temp);
    }

    //All the permutations
    public void solve(String pattern,StringBuilder sb,List<String>list,int idx){
        if(idx==sb.length()){
            if(isValid(pattern,sb)){
                list.add(sb.toString());
            }
            return ;
        }

        for(int i=idx;i<sb.length();i++){
            swap(sb,i,idx);
            solve(pattern,sb,list,idx+1);
            swap(sb,idx,i);
        }
    }
    public String smallestNumber(String pattern) {
        int n=pattern.length();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n+1;i++){
            sb.append(i);
        }

        List<String>list=new ArrayList<>();

        solve(pattern,sb,list,0);

        Collections.sort(list);

        return list.get(0);//Lexicographically smallest string.
    }
}
```

# Stack
```java
class Solution {
    public String smallestNumber(String pattern) {
        int n=pattern.length();
        Stack<Integer>st=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<=n;i++){//n+1 size of the Answer
            st.push(i+1);//pushing one increased value
            if(i==n || pattern.charAt(i)=='I'){//if the character is Increasing
                while(!st.isEmpty()){
                    sb.append(st.pop());//pop the element 
                }
            }
        }

        return sb.toString();
    }
}
```
