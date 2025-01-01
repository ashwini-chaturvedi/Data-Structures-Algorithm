```java
class Solution {
    public int longestCommonSubstr(String s1, String s2) {
       int m=s1.length();
       int n=s2.length();
       
       int[][] topDown=new int[m+1][n+1];
      
       int maxLen=Integer.MIN_VALUE;
       
       for(int i=0;i<m+1;i++){
           for(int j=0;j<n+1;j++){
               if(i==0 || j==0){
                   topDown[i][j]=0;
               }else if(s1.charAt(i-1)==s2.charAt(j-1)){
                   topDown[i][j]=1+topDown[i-1][j-1];
                   maxLen=Math.max(maxLen,topDown[i][j]);//maximum length when same elements are found
               }else{
                   topDown[i][j]=0;//when the element don't match then it cannot form a common substring so start from zero 
               }
           }
       }
       
       return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
}
```
