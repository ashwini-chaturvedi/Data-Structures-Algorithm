----------------------------------------->Approach:1<-----------------------------------------------------------
  /*
    substring(beginIndex, endIndex): O(n) where n is the length of the substring.
    equals(String other): O(n) where n is the length of the strings being compared.
    

    Time Complexity:O(N^2)
    Space Complexity:O(N)
*/
# With Comments
```java
class Solution {
    public String shortestPalindrome(String s) {
        String rev=new StringBuilder(s).reverse().toString();//Reverse the Original String

        for(int i=0;i<s.length();i++){
//check both the reverse and original one by one after which point you get a Palindrome
            if(s.substring(0,s.length()-i).equals(rev.substring(i))){//if after point i you get a Palindrome
// So now just concatenate the remaining non-palindromic substring in reverse String in front of the original string 
//this will give the minimum length of substring to be concatenated to make the String Palindrome
                return rev.substring(0,i)+s;//concatinating the remaining non-palindromic substring
            }
        }
        return rev+s;
    }
}
```
# With Out Comments
```java
class Solution {
    public String shortestPalindrome(String s) {
        String rev=new StringBuilder(s).reverse().toString();

        for(int i=0;i<s.length();i++){

            if(s.substring(0,s.length()-i).equals(rev.substring(i))){
                return rev.substring(0,i)+s;
            }
        }
        return rev+s;
    }
}
```

----------------------------------------->Approach:2<-----------------------------------------------------------
USING Knuth-Morris-Pratt (KMP) algorithm
Must Watch 
1. Abdul Bari Video:  https://youtu.be/V5-7GzOfADQ?si=1cEEtt1WBTLmCQpv
2. Code Story With Mik Video:  https://youtu.be/qases-9gOpk?si=tmESnY4pWhMnMovk
