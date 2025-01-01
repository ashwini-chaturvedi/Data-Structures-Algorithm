```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        //2D Array size is m+1 & n+1 because the Index of both the String are the things that are changing Continuosly.
        int[][] topDown=new int[m+1][n+1];

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){

                if(i==0 || j==0){
                    topDown[i][j]=0;//Initialization
                }else if(text1.charAt(i-1)==text2.charAt(j-1)){//Charcter is equal/common then Exclude both Characters from String X & Y so i-1 & j-1 . Also plus one because we have found one commom character.
                    topDown[i][j]=1+topDown[i-1][j-1];
                }else{/*if Charaters are not equal then we have 2 options
                        1. Either to Include Character that was in String X and Exclude Character that was is String Y 
                        2. Or to Exclude Character that was in String X and Include Character that was in String Y*/
                    int includeX=topDown[i][j-1];//Include X, Exclude Y
                    int includeY=topDown[i-1][j];//Exclude X, Include Y

                    topDown[i][j]=Math.max(includeX,includeY);//Maximum Commom character found in any one of the options should be Stored.
                }
            }
        }

        return topDown[m][n];
    }
}
```
