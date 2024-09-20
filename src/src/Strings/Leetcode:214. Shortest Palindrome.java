----------------------------------------->Approach:1<-----------------------------------------------------------
  /*
    substring(beginIndex, endIndex): O(n) where n is the length of the substring.
    equals(String other): O(n) where n is the length of the strings being compared.

    Time Complexity:O(N^2)
    Space Complexity:O(N)
*/
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

----------------------------------------->Approach:2<-----------------------------------------------------------
USING Knuth-Morris-Pratt (KMP) algorithm
Must Watch 
1. Abdul Bari Video:  https://youtu.be/V5-7GzOfADQ?si=1cEEtt1WBTLmCQpv
2. Code Story With Mik Video:  https://youtu.be/qases-9gOpk?si=tmESnY4pWhMnMovk
