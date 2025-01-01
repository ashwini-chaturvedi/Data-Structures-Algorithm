```java
class Solution {
    public String printLCS(String s, String t) {
        int m=s.length();
        int n=t.length();
        
        int[][] topDown=new int[m+1][n+1];
        
        
        
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    topDown[i][j]=0;
                }else if(s.charAt(i-1)==t.charAt(j-1)){
                    topDown[i][j]=1+topDown[i-1][j-1];
                }else{
                    int includeX=topDown[i][j-1];
                    int includeY=topDown[i-1][j];
                    
                    topDown[i][j]=Math.max(includeX,includeY);
                }
            }
        }


//This Movement to the Up(when same Character) and to the maximum cell when different Characters
        int i=m;
        int j=n;
    
        StringBuilder sb=new StringBuilder();       
        while(i>0 && j>0 ){
            
            if(s.charAt(i-1)==t.charAt(j-1)){//when same character
                sb.insert(0,s.charAt(i-1));
                i--;
                j--;
            }else{
                if(topDown[i-1][j]>topDown[i][j-1]){//Go to the maximum cell 
                    i--;
                }else{
                    j--;
                }
            }
        }
    
        
        return sb.toString();
    }
}
```
