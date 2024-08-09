package Backtracking;
//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class largestNumberIn_Kswaps {
    public static int maxEle(String s){
        int maxx=0;
        for(char ch:s.toCharArray()){
            int ascii=(int)(ch-'0');
            maxx=Math.max(ascii,maxx);
        }
        return maxx;
    }
    public static String swap(String s,int idx,int i){
        char[]chars=s.toCharArray();
        char temp=chars[i];
        chars[i]=chars[idx];
        chars[idx]=temp;
        return new String(chars);
    }
    public static String solve(String s,String res,int idx,int k){
        if(k==0||idx==s.length()){
            return res;
        }
        int max=maxEle(s.substring(idx));
        for(int i=idx+1;i<s.length();i++){
            if(s.charAt(idx)<s.charAt(i)&&(int)(s.charAt(i)-'0')==max){
                s=swap(s,idx,i);
                int ans=Integer.parseInt(s);
                int prev=Integer.parseInt(res);
                if(ans>prev){
                    res=s;
                }
                res=solve(s,res,idx+1,k-1);
                s=swap(s,idx,i);
            }else{
                res=solve(s,res,idx+1,k);
            }


        }
        return res;
    }
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        //code here.
        String res=str;

         res=solve(str,res,0,k);
         return res;
    }
    public static void main(String[] args) {
        String s="4551711527";

        System.out.println(findMaximumNum(s,3));
    }
}
