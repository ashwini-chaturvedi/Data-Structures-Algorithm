```java
class Solution {
    public int minOperations(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        
        int[][] topDown=new int[m+1][n+1];
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==0 || j==0) 
                    topDown[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    topDown[i][j]=1+topDown[i-1][j-1];
                }else{
                    int includeX=topDown[i][j-1];
                    int includeY=topDown[i-1][j];
                    
                    topDown[i][j]=Math.max(includeX,includeY);
                }
            }
        }

//Go from s1 to s2 via LCS so, s1--->LCS--->s2
        
        int del=0;//number of Deletion=s1.length()-LCS.length()
        del+=s1.length()-topDown[m][n];
        
        int ins=0;//number of Insertion=s2.length()-LCS.length();
        ins+=s2.length()-topDown[m][n];
        
        return del+ins;
    }
}
```
