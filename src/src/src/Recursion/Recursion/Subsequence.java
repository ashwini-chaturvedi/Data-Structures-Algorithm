package Recursion.Recursion;

import java.util.ArrayList;

public class Subsequence {
    public static ArrayList<String> getSub(String str){
        ArrayList<String> res=new ArrayList<>();
        if(str.isEmpty()){
            res.add("");
            return res;
        }
        char ch=str.charAt(0);
        ArrayList<String> ans=getSub(str.substring(1));
        for(String s:ans){
            res.add(s);
            res.add(ch+s);
        }
        return res;

    }
    public static void get(String str){
        ArrayList<String> res=new ArrayList<>();
        if(str.isEmpty()){
            System.out.println("");
            return ;
        }
        char ch=str.charAt(0);
        ArrayList<String> ans=getSub(str.substring(1));
        for(String s:ans){

            System.out.print(","+s);
            System.out.print(","+ch+s);
        }
    }
    public static void printSubSequence(String str,String currAns){
        if(str.isEmpty()){
            System.out.print(","+currAns);
            return;
        }
        char curr=str.charAt(0);
        String remString=str.substring(1);//make a new string after leaving the character at Index 1
        //currchar -> choses to be a part of current answer
        printSubSequence(remString,currAns+curr);//choses to be part so appending the char

        //curr char-> chooses does not want to be part of curr answer
        printSubSequence(remString,currAns);

    }
    //Print sum of all the subsets.
    public static void sumofSubsets(int []nums,int currAns,int idx,int size){
        if(idx>=size){
            System.out.print(currAns+",");
            return;
        }
        sumofSubsets(nums,currAns+nums[idx],idx+1,size);
        sumofSubsets(nums,currAns,idx+1,size);
    }
    public static void main(String[]args){
        String str="abc";
        System.out.println(getSub(str));
        get(str);
        System.out.println("\n");

        printSubSequence("abc","");//empty current answer string
        System.out.println("\n");
        int []nums={2,4,5};
        sumofSubsets(nums,0,0,nums.length);

        int qno=25;
        String Event="Java Quiz";
        System.out.printf("Event %s Qno %d",Event,qno);
    }
}
