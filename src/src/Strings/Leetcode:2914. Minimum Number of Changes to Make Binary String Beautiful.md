```java
class Solution {
    //As the String is of Even Length so  divide the String into chunks of length of 2 and check the changes needed to make that chunk beautiful and treverse through whole String.
    public int minChanges(String s) {
        int changes=0;
        for(int i=0;i<s.length();i+=2){
            if(s.charAt(i)!=s.charAt(i+1)){
                changes++;
            }
        }
        return changes;
    }
}
```
