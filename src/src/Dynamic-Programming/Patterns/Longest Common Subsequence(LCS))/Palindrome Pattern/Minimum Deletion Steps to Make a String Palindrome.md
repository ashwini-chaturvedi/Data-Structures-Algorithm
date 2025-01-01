```java
class Solution 
{ 
    int minDeletions(String s, int size){
        //
        StringBuilder reversedS=new StringBuilder(s).reverse();
        
        int m=s.length();
        int n=reversedS.length();
        
        int[][] topDown=new int[m+1][n+1];
        
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    topDown[i][j]=0;
                }else if(s.charAt(i-1)==reversedS.charAt(j-1)){
                    topDown[i][j]=1+topDown[i-1][j-1];
                }else{
                    int includeX=topDown[i][j-1];
                    int includeY=topDown[i-1][j];
                    
                    topDown[i][j]=Math.max(includeX,includeY);
                }
            }
        }
        
        int del=s.length()-topDown[m][n];//Number of Deletion=length of String - length of LCS.
        return del;
    }
} 
```
