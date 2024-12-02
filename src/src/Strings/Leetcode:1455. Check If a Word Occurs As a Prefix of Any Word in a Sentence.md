```java
class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str = sentence.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (str[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
```
```java
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str=sentence.split(" ");
        
        for(int i=0;i<str.length;i++){
            if(str[i].charAt(0)==searchWord.charAt(0)){
                int j=0;
                while(j<str[i].length() && j<searchWord.length()){
                    if(str[i].charAt(j)!=searchWord.charAt(j)) break;

                    j++;
                }
                if(j==searchWord.length()) return i+1;
            }
        }
        return -1;

    }
}
```
