package Backtracking;

import java.util.*;

class BruteForce {
    public String swap(String s,int idx,int i){
        char[]chars=s.toCharArray();
        char temp=chars[i];
        chars[i]=chars[idx];
        chars[idx]=temp;
        return new String(chars);
    }
    public void solve(String s,int idx,List<String>list,Set<String>set,int k){
        if(idx==s.length()-1){
            if(!set.contains(s)){
                list.add(s);
                set.add(s);

            }
            return;
        }
        if(list.size()==k){
            return;
        }

        for(int i=idx;i<s.length();i++){
            s=swap(s,idx,i);
            solve(s,idx+1,list,set,k);
            s=swap(s,idx,i);
        }
    }
    public String getPermutation(int n, int k) {
        String s="";
        for(int i=1;i<=n;i++){
            s=s+i;
        }
        List<String> list=new ArrayList<>();
        Set<String> set=new HashSet<>();

        solve(s,0,list,set,k);
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}
public class permutationSequence {
    public static void main(String[] args) {
        BruteForce bf=new BruteForce();
        System.out.println(bf.getPermutation(9,2678));
    }
}
