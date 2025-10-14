```java
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0;
        int j=0;

        while(i<str1.length() && j<str2.length()){
            char ch1=str1.charAt(i);
            char ch2=str2.charAt(j);

            if(ch1!=ch2){
                int val=(ch2-'a')-1;
                char newChar=(char)(val+'a');

                if((ch1=='z' && ch2=='a') || newChar==ch1){
                    i++;
                    j++;

                }else{
                    i++;
                }
                
            }else{
                i++;
                j++;
            }
        }

        return j==str2.length();
    }
}
```
