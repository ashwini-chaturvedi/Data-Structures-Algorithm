```java

class Solution{
    public static int MCM(String s,int i,int j,boolean isTrue,Map<String,Integer>memoiz){
        if(i>j) return 0;
        
        String key=i+"_"+j+"_"+isTrue;
        if(memoiz.containsKey(key)){
            return memoiz.get(key);
        }
        
        if(i==j){
            if(isTrue){//if we found the True in String
                return s.charAt(i)=='T'?1:0;//if Single Element is true and we want to find true return true 
            }else{
                return s.charAt(i)=='F'?1:0;
            }
        } 
        
        int ans=0;
        for(int k=i+1;k<=j-1;k+=2){
            int lTrue=MCM(s,i,k-1,true,memoiz)%1003;
            int lFalse=MCM(s,i,k-1,false,memoiz)%1003;
            int rTrue=MCM(s,k+1,j,true,memoiz)%1003;
            int rFalse=MCM(s,k+1,j,false,memoiz)%1003;
            
            
            if(s.charAt(k)=='&'){
                if(isTrue){
                    ans=ans+lTrue*rTrue;
                }else{
                    ans=ans+lFalse*rTrue+lFalse*rFalse+lTrue*rFalse;
                }
            }else if(s.charAt(k)=='|'){
                if(isTrue){
                    ans=ans+lTrue*rTrue+lTrue*rFalse+lFalse*rTrue;
                }else{
                    ans=ans+lFalse*rFalse;
                }
            }else if(s.charAt(k)=='^'){
                if(isTrue){
                    ans=ans+lFalse*rTrue+lTrue*rFalse;
                }else{
                    ans=ans+lTrue*rTrue+lFalse*rFalse;
                }
            }
        }
        memoiz.put(key,ans%1003);
        return ans%1003;
    }
    static int countWays(int n, String s){
        Map<String,Integer>memoiz=new HashMap<>();//key=i_j_isTrue
        
        
        return MCM(s,0,s.length()-1,true,memoiz);
    }
}
```
