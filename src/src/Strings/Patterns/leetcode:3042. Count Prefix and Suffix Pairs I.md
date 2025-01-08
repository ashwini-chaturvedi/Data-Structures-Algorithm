```java
class Solution {
    public boolean isPrefixAndSuffix(String s,String t){
        if(s.length()>t.length()) return false;//if the size of the s is greater than t .than s can never be a prefix and suffix of the String t.

        if(t.startsWith(s) && t.endsWith(s)) return true;//Prefix and Suffix...

        return false;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){//i<j always

                if(isPrefixAndSuffix(words[i],words[j])){
                    count++;
                }
            }
        }
        return count;
    }
}
```
