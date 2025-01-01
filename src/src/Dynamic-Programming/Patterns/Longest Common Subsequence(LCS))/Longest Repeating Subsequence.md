```java
class Solution {
    public int LongestRepeatingSubsequence(String s1) {
       String s2=new String(s1);
       
       int m=s1.length();
       int n=s2.length();
       
       int[][] topDown=new int[m+1][n+1];
       
       for(int i=0;i<m+1;i++){
           for(int j=0;j<n+1;j++){
               if(i==0 || j==0){
                   topDown[i][j]=0;
               }else if(s1.charAt(i-1)==s2.charAt(j-1) && i!=j){//don't Include the characters at same Strings in both the Strings 
                   topDown[i][j]=1+topDown[i-1][j-1];
               }else{
                   int includeX=topDown[i][j-1];
                   int includeY=topDown[i-1][j];
                   
                   topDown[i][j]=Math.max(includeX,includeY);
               }
           }
       }
       
       return topDown[m][n];
    }
}
```
