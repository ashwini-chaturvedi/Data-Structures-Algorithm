//Choices and Decision Pattern of Recursion.
//we have choice to Either take the character as Extra Character and Skip it or take it in our substring.
class Solution {    
    //Focus on to the substrings and there index what is the length of the substring to be Created.
    public int solve(String s,Set<String>set,int n,int idx,int[] memoiz){
        if(idx>=n) return 0;//Out of Bound.

        if(memoiz[idx]!=-1){
            return memoiz[idx];
        }

        //DECISION.1:Skipping the Current Character
        int result=1+solve(s,set,n,idx+1,memoiz);
        //As we skip the character we have to do plus one Considering that character is the Extra Character

        for(int i=idx;i<n;i++){
            String currSubstring=s.substring(idx,i+1);
            if(set.contains(currSubstring)){
                //This currSubstring is a Valid String so easily break it.
                result=Math.min(result,solve(s,set,n,i+1,memoiz));
            }
        }
        return memoiz[idx]=result;
    }
    public int minExtraChar(String s, String[] dictionary) {
        int[]memoiz=new int[51];
        Arrays.fill(memoiz,-1);
        Set<String>set=new HashSet<>(Arrays.asList(dictionary));
        int idx=0;
        return solve(s,set,s.length(),idx,memoiz);
    }
}
