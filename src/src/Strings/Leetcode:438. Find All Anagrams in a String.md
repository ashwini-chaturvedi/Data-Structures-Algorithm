```java
class Solution {
    boolean allZero(int[]counter){
        for(int i:counter){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result=new ArrayList<>();
        
        int[]counter=new int[26];//Use this array to Store the occurence of all the characters in String 'p'.
        char []pAtChar=p.toCharArray();
        for(char ch:pAtChar){
            counter[ch-'a']++;
        }

        int i=0;
        int j=0;
        int k=p.length();//Window size will be of length of 'p'.

        while(j<s.length()){
            counter[s.charAt(j)-'a']--;//Decrease the count of the characters you encountered.
            if((j-i)+1==k){//if window size is matched
                if(allZero(counter)){//check if the count of all the characters have become zero which means we have found our anagram then add the 'i' which is starting point of the anagram into the result.
                    result.add(i);
                }
                counter[s.charAt(i)-'a']++;//after checking increase the count of the character for later use
                i++;
            }
            j++;
        }
        return result;
    }
}
```
