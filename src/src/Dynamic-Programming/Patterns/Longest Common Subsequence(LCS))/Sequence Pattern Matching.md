```java
public class SequencePattenMatching {
    public static boolean isPatternMatching(String s1,String s2){
        int m=s1.length();
        int n=s2.length();

        int[][] topDown=new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
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
        System.out.println(topDown[m][n]);
        return (m==topDown[m][n] || n==topDown[m][n]);
    }
    public static void main(String[] args) {
        String s1="AXY";
        String s2="ADXCPY";

        System.out.println(isPatternMatching(s1,s2));
    }
}

```
