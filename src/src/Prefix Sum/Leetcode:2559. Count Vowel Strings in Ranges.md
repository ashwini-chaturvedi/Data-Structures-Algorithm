```java
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix=new int[words.length];
        int k=0;
        for(String word:words){
            char first=word.charAt(0);
            char last=word.charAt(word.length()-1);

            if(
                (first=='a' || first=='e' || first=='i' || first=='o' || first=='u')
            &&
                (last=='a' || last=='e' || last=='i' || last=='o' || last=='u')            
            ){
                prefix[k++]=1;
            }else{
                prefix[k++]=0;
            }
        }

        for(int i=1;i<prefix.length;i++){
            prefix[i]+=prefix[i-1];
        }

        k=0;
        int[] res=new int[queries.length];
        for(int[] query:queries){
            int l=query[0];
            int r=query[1];

            res[k++]=l==0?prefix[r]:(prefix[r]-prefix[l-1]);
        }

        return res;
    }
}

```
