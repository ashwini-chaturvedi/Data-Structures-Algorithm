```java
class Solution {
    public String findRoot(String word,Set<String>set){
        for(int i=1;i<=word.length();i++){

            String root=word.substring(0,i);//Take a Part of the Word and try to find it in set if it is present which means it is root then we will return the root.
            if(set.contains(root)){
                return root;
            }
        }
        return word;//Else whole string is considered as root
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String>set=new HashSet<>(dictionary);//Add all the Words of dictionary into a Set
        StringBuilder res=new StringBuilder();

        String[] words=sentence.split(" ");//Separate all the word in the sentence

        for(String word:words){
            res.append(findRoot(word,set)).append(" ");//double appending
        }
        return res.toString().trim();
        
    }
}
```
