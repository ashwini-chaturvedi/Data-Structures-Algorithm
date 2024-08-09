package Backtracking;
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;



public class permutationOfString {
    public static String swap(String s,int idx,int i){
        //function to swap the characters
        char[]chars=s.toCharArray();//changing string to character array
        //swapping the characters...
        char temp=chars[idx];
        chars[idx]=chars[i];
        chars[i]=temp;
        return new String(chars);//returning new string having all elements of chars character array...
    }
    public static void solve(String s,int idx,List<String>list,Set<String>set){
        if(idx==s.length()-1){
            if(!set.contains(s)){
                //checking if the string is already a part of answer or not this will give us unique strings as output

                list.add(s);
                set.add(s);
            }

            return;
        }
        for(int i=idx;i<s.length();i++){
            s=swap(s,i,idx);//mutating the string str directly
            solve(s,idx+1,list,set);//calling the function recursively
            //Backtracking
            s=swap(s,i,idx);//re mutating the string str which will bring it to its original
            //state this is called BackTracking...
        }
    }
    public static List<String> find_permutation(String S) {
        // Code here
        List<String>list=new ArrayList<>();
        Set<String>set=new HashSet<>();
        solve(S,0,list,set);
//        Collections.sort(list);//sorting the arraylist in lexicographical order...
        sortLexicographically(list);
        return list;
    }
    public static void sortLexicographically(List<String> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    // Swap list[j] with list[j + 1]
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
    public static void main(String[]args){

        System.out.println(find_permutation("ABC"));
    }
}
