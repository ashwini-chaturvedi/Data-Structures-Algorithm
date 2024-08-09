package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class letterTiles {
    public static void solve(String input,List<String>list,int[]count,int idx, List< List<String>> ans){
        if(idx==input.length()){
            ans.add(new ArrayList<>(list));
            count[0]+=1;
            return;
        }
        for(int i=idx;i<input.length();i++){
            list.add(input.charAt(i)+"");
            solve(input,list,count,idx+1,ans);
            list.remove(list.size()-1);
        }

    }
    public static int numTilePossibilities(String tiles) {
        int[]count={0};
        List<String> list=new ArrayList<>();
       List< List<String>> ans=new ArrayList<>();
        solve(tiles,list,count,0,ans);
        System.out.println(ans);
        return count[0];
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
    }
}
