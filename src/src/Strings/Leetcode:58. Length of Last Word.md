```java
class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
           if(ch!=' '){
               count++;
           }else {
               if(count>0){//String can also have spaces at the last so if the count has increased then only return the count otherwise don't do anything
                   return count;
               }
           }
        }
        return count;
    }
}
```
