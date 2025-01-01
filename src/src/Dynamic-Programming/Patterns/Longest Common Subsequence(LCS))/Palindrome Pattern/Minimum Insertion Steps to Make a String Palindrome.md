```java
class Solution {
    public int minInsertions(String s1) {
        StringBuilder s2=new StringBuilder(s1).reverse();

        int n=s1.length();

        int[][] topDown=new int[n+1][n+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    topDown[i][j]=0;
                }else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    topDown[i][j]=1+topDown[i-1][j-1];
                }else{
                    int includeX=topDown[i][j-1];
                    int includeY=topDown[i-1][j];

                    topDown[i][j]=Math.max(includeX,includeY);
                } 
            }
        }

        int insert=n-topDown[n][n];//steps to insert=length of the string - length LCS
        return insert;
    }
}
```
